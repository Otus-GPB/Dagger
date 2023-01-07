package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityComponent: MainActivityComponent
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityComponent = SingleApplicationComponent
            .getInstance()
            .mainActivityComponentFactory()
            .create(this)
        setContentView(R.layout.activity_main)
    }
}