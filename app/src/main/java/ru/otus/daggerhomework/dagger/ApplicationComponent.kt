package ru.otus.daggerhomework.dagger


import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.MainActivity

@Component (modules = [Provider::class])
interface ApplicationComponent {
    val getAppContext: Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: App): ApplicationComponent
    }


}

