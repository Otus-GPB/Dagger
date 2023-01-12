package ru.otus.daggerhomework.dagger

import androidx.lifecycle.MutableLiveData
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.*

@Module()
class FragmentProducerModule {
   @FragmentScope
    @Provides
    fun provideProducer(
        generator: ColorGenerator,
        context: MainActivity,
        mutableData: MutableLiveData<Int>
    ): ViewModelProducer {
        return ViewModelProducer(generator, context, mutableData)
    }
}

@Module
interface Implement {
    @Binds
    fun toGenerator(generator: ColorGeneratorImpl): ColorGenerator
}
