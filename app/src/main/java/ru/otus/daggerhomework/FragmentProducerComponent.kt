package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module
import dagger.Subcomponent

@Subcomponent(modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {
    @Subcomponent.Factory
    interface Factory{
        fun create(): FragmentProducerComponent
    }
    fun inject(fragmentProducer: FragmentProducer)
}

@Module
abstract class FragmentProducerModule {
    @Binds
    abstract fun colorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}