package ru.otus.daggerhomework

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import ru.otus.daggerhomework.dagger.Fragment
import javax.inject.Inject

@Fragment
class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    val context: Context,
    private val mutableData: MutableLiveData<Int>
) {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        mutableData.value = colorGenerator.generateColor()
    }
}