package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ViewModelReceiver(
    private val context: Context,
    private val mutableLiveData: MutableLiveData<Int>

) {

    fun observeColors() : MutableLiveData<Int>{
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        return mutableLiveData
    }
}