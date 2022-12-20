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
        fun create(activityComponent: MainActivityComponent): FragmentProducerComponent
    }

    fun inject(producer: FragmentProducer)
}

@Module
interface FragmentProducerModule {

    companion object {
        @FragmentScope
        @Provides
        fun provideViewModelProducer(
            colorGenerator: ColorGenerator,
            activity: MainActivity,
            liveData: MutableLiveData<Int>
        ): ViewModelProducer {
            return ViewModelProducer(
                colorGenerator = colorGenerator,
                context = activity,
                color = liveData
            )
        }

        @FragmentScope
        @Provides
        fun provideColorGenerator(): ColorGenerator {
            return ColorGeneratorImpl()
        }
    }
}
