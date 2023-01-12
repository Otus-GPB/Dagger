package ru.otus.daggerhomework

import androidx.lifecycle.LiveData

interface InterfaceVMReceiver {
    fun observeColors(): LiveData<Int>
}