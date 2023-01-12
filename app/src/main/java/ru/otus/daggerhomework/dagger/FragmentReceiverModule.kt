package ru.otus.daggerhomework.dagger


import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ViewModelReceiver
import ru.otus.daggerhomework.InterfaceVMReceiver

@Module
interface FragmentReceiverModule {
    @Binds
    fun bindViewModelReceiver(vm:ViewModelReceiver): InterfaceVMReceiver
}