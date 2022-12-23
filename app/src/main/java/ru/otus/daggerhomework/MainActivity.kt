package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.dagger.ApplicationComponent
import ru.otus.daggerhomework.dagger.DaggerMainActivityComponent
import ru.otus.daggerhomework.dagger.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var applicationComponent: ApplicationComponent
    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        applicationComponent = (applicationContext as App).appComponent
        mainActivityComponent = DaggerMainActivityComponent
            .factory()
            .create(this, applicationComponent)
        mainActivityComponent.inject(this)

        supportFragmentManager.beginTransaction().addToBackStack(null)
            .replace(R.id.sender, FragmentProducer())
            .commit()

        supportFragmentManager.beginTransaction().addToBackStack(null)
            .replace(R.id.receiver, FragmentReceiver())
            .commit()
    }
}