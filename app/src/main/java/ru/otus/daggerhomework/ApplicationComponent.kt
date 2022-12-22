package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Qualifier
import javax.inject.Scope

@Qualifier
annotation class ApplicationContext

@MySingletonScope
@Component(modules = [AppSubcomponents::class])
interface ApplicationComponent{
    @Component.Factory
    interface Factory{
        fun create(@ApplicationContext @BindsInstance
                   appContext: Context): ApplicationComponent
    }
    fun mainActivityComponentFactory(): MainActivityComponent.Factory
}

@Module(subcomponents = [MainActivityComponent::class])
class AppSubcomponents


@Scope
annotation class MySingletonScope