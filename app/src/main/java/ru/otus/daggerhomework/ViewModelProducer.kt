package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import ru.otus.daggerhomework.di.FragmentScope
import javax.inject.Inject
import javax.inject.Named

@FragmentScope
class ViewModelProducer @Inject constructor(
    private val observer: MutableLiveData<Int>,
    private val colorGenerator: ColorGenerator,
    @Named("ActivityContext")
    private val context: Context
) {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        val color = colorGenerator.generateColor()
        observer.value = color
    }
}