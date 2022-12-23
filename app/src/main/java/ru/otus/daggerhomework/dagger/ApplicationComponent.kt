package ru.otus.daggerhomework.dagger


import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.App

@Component(modules = [ApplicationComponentModule::class])
interface ApplicationComponent {

    val context: Context

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): ApplicationComponent
    }
}

@Module
class ApplicationComponentModule {
    @Provides
    fun provideContext(app: App): Context = app.applicationContext
}