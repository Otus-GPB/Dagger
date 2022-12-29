package ru.otus.daggerhomework.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.App
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [AppSubcomponentsModule::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory{
        fun create(@Named("AppContext")@BindsInstance context: Context): ApplicationComponent
    }
    fun mainActivityComponent(): MainActivityComponent.Factory
}