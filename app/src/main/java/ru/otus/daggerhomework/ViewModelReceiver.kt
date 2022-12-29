package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.otus.daggerhomework.di.FragmentScope
import javax.inject.Inject
import javax.inject.Named

@FragmentScope
class ViewModelReceiver @Inject constructor(
    private val observer: MutableLiveData<Int>,
    @Named("AppContext")
    private val context: Context
) {

    fun observeColors(): MutableLiveData<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        return observer
    }
}