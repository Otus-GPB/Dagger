package ru.otus.daggerhomework.di

import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides

@Module
class ObserverModule {
    @ActivityScope
    @Provides
    fun provideObserver(): MutableLiveData<Int>{
        return MutableLiveData<Int>()
    }
}