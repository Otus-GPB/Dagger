package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides

@Module
class ReceiverModule {

    @ReceiverScope
    @Provides
    fun provideViewModelReceiver(
        context: Context,
        liveData: MutableLiveData<Int>)
    : ViewModelReceiver = ViewModelReceiver(context, liveData as LiveData<Int>)

}