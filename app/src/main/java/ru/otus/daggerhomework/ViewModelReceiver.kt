package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.otus.daggerhomework.dagger.Fragment
import javax.inject.Inject

@Fragment
class ViewModelReceiver @Inject constructor(
    private val context: Context,
    liveData: MutableLiveData<Int>
) {
    private val colorLiveData: LiveData<Int> = liveData
    fun observeColors(): LiveData<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        return colorLiveData
    }
}