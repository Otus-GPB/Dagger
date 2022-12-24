package ru.otus.daggerhomework

import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides

@Module
class ProducerModule {

    @ProducerScope
    @Provides
    fun provideViewModelProducer(
        colorGenerator: ColorGenerator,
        activity: MainActivity,
        colorState: MutableLiveData<Int>
    ): ViewModelProducer = ViewModelProducer(colorGenerator, activity, colorState)

    @ProducerScope
    @Provides
    fun provideColorGenerator(): ColorGenerator = ColorGeneratorImpl()
}