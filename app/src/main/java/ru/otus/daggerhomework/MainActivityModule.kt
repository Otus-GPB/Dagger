package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class MainActivityModule {

    @Provides
    @ActivityScope
    @Named("MainActivity")
    fun provideMainActivity(mainActivity: MainActivity): Context = mainActivity

    @Provides
    @ActivityScope
    fun provideMutableColorState(): MutableLiveData<Int> = MutableLiveData()

    @Provides
    @ActivityScope
    fun provideColorState(mutableLiveData: MutableLiveData<Int>): LiveData<Int> = mutableLiveData
}