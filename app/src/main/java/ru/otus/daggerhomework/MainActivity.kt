package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_producer_container, FragmentProducer())
            .replace(R.id.fragment_receiver_container, FragmentReceiver())
            .commit()

        mainActivityComponent = DaggerMainActivityComponent
            .factory()
            .create(
                activity = this,
                applicationComponent = (applicationContext as App).applicationComponent
            )
        mainActivityComponent.inject(this)
    }
}