package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.otus.daggerhomework.dagger.FragmentScope
import javax.inject.Inject

@FragmentScope
class ViewModelReceiver @Inject constructor(
    private val context: Context,
    private val liveData: MutableLiveData<Int>
) {
    val colorLiveData: LiveData<Int> = liveData
    fun observeColors(): LiveData<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        return colorLiveData
    }
}