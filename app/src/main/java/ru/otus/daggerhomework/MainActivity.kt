package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ru.otus.daggerhomework.dagger.ApplicationComponent
import ru.otus.daggerhomework.dagger.DaggerMainActivityComponent
import ru.otus.daggerhomework.dagger.MainActivityComponent

class MainActivity : AppCompatActivity() {

    var mainComponent: MainActivityComponent? = null
    var appComp: ApplicationComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComp = (applicationContext as App).appComponent
        mainComponent = DaggerMainActivityComponent.factory().create(this, appComp!!)

        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.openFragmentProducer).setOnClickListener {
            supportFragmentManager.beginTransaction().addToBackStack(null)
                .replace(R.id.fragmentContainer, FragmentProducer())
                .commit()
        }
        findViewById<Button>(R.id.openFragmentReceiver).setOnClickListener {
            supportFragmentManager.beginTransaction().addToBackStack(null)
                .replace(R.id.fragmentContainer, FragmentReceiver())
                .commit()
        }
    }


    override fun onStop() {
        super.onStop()
        mainComponent = null
    }
}
