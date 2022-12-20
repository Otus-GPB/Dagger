package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

@FragmentScope
class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val color: MutableLiveData<Int>
) {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        color.value = colorGenerator.generateColor()
    }
}
