package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

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

    fun provideMutableStateColor(): MutableLiveData<Int>
    fun provideStateColor(): LiveData<Int>
    @Named("MainActivity")
    fun provideMainActivity(): Context
    fun provideContext(): Context
}