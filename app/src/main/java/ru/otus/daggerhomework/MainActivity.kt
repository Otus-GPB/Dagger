package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import ru.otus.daggerhomework.dagger.ApplicationComponent
import ru.otus.daggerhomework.dagger.DaggerMainActivityComponent
import ru.otus.daggerhomework.dagger.MainActivityComponent

class MainActivity : AppCompatActivity() {

    var mainComponent: MainActivityComponent? = null
    private var appComponent: ApplicationComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.openFragmentProducer).setOnClickListener{
        supportFragmentManager.beginTransaction().addToBackStack(null)
            .replace(R.id.fragmentContainer, FragmentProducer())
            .commit()
        }
        findViewById<Button>(R.id.openFragmentReceiver).setOnClickListener{
           supportFragmentManager.beginTransaction().addToBackStack(null)
               .replace(R.id.fragmentContainer, FragmentReceiver())
               .commit()
        }
    }

    override fun onStart() {
        Log.i("AAA", "onStart")
        appComponent =  (applicationContext as App).appComponent
        mainComponent = DaggerMainActivityComponent.factory().create(this,appComponent!!)
        appComponent?.inject(this)
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
        mainComponent = null
        appComponent = null
    }
}
