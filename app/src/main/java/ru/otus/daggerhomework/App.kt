package ru.otus.daggerhomework

import android.app.Application

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        SingleApplicationComponent
            .initApplicationComponent(applicationContext)
    }
}