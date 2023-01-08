package ru.otus.daggerhomework

import androidx.lifecycle.MutableLiveData
import dagger.Component
import dagger.Module
import dagger.Provides

@FragmentScope
@Component(dependencies = [MainActivityComponent::class], modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent) : FragmentProducerComponent
    }

    fun inject(fragmentProducer: FragmentProducer)
}

@Module
class FragmentProducerModule {

    @FragmentScope
    @Provides
    fun provideViewModelProducer(
        colorGenerator: ColorGenerator,
        activity: MainActivity,
        mutableLiveData: MutableLiveData<Int>
    ) : ViewModelProducer = ViewModelProducer(colorGenerator, activity, mutableLiveData)

    @FragmentScope
    @Provides
    fun provideColorGenerator(): ColorGenerator = ColorGeneratorImpl()
}