package ru.otus.daggerhomework

import android.app.Application

class App : Application() {

    private var _applicationComponent: ApplicationComponent? = null

    val applicationComponent: ApplicationComponent
        get() {
            if (_applicationComponent == null) {
                _applicationComponent = createApplicationComponent()
            }
            return _applicationComponent as ApplicationComponent
        }

    private fun createApplicationComponent(): ApplicationComponent =
        DaggerApplicationComponent.factory()
            .create(this)
}