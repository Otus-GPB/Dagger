package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.MutableLiveData
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activity: MainActivity,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }

    fun inject(mainActivity: MainActivity)

    fun provideContext(): Context

    fun provideActivity(): MainActivity

    fun provideColor(): MutableLiveData<Int>
}

@Module
interface MainActivityModule {

    companion object {

        @ActivityScope
        @Provides
        fun provideMutableLiveData(): MutableLiveData<Int> {
            return MutableLiveData<Int>()
        }
    }
}
