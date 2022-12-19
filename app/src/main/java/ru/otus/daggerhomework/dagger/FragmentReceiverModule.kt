package ru.otus.daggerhomework.dagger


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.ViewModelReceiver
import javax.inject.Named

@Module
class FragmentReceiverModule {
    @FragmentScope
    @Provides
    fun provideViewModelReceiver(
        context: Context,
        liveData: MutableLiveData<Int>
    ): ViewModelReceiver {
        return ViewModelReceiver(context, liveData)
    }

}