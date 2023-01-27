package ru.otus.daggerhomework.dagger


import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component
@Singleton
interface ApplicationComponent {
    val getAppContext: Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Context): ApplicationComponent
    }


}

