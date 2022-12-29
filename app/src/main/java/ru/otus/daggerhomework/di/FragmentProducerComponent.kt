package ru.otus.daggerhomework.di

import dagger.Subcomponent
import ru.otus.daggerhomework.FragmentProducer

@FragmentScope
@Subcomponent(modules = [ColorGeneratorModule::class])
interface FragmentProducerComponent {
    @Subcomponent.Factory
    interface Factory{
        fun create(): FragmentProducerComponent
    }
    fun inject(fragment: FragmentProducer)
}