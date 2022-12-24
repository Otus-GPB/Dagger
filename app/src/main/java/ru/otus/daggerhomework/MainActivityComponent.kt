package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.MutableLiveData
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activity: MainActivity,
            appComponent: ApplicationComponent)
        : MainActivityComponent
    }

    fun provideStateColor(): MutableLiveData<Int>
    fun provideMainActivity(): MainActivity
    fun provideContext(): Context
}