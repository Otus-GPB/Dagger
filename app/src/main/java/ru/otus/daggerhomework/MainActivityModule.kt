package ru.otus.daggerhomework

import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    @ActivityScope
    fun provideColorState():MutableLiveData<Int> = MutableLiveData<Int>()
}