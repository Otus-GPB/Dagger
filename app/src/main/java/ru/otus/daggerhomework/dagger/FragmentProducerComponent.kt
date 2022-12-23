package ru.otus.daggerhomework.dagger

import androidx.lifecycle.MutableLiveData
import dagger.*
import ru.otus.daggerhomework.*
import javax.inject.Scope

@Component(dependencies = [MainActivityComponent::class], modules = [FragmentProducerModule::class, Generator::class])
@Fragment
interface FragmentProducerComponent {

    val viewModelProducer: ViewModelProducer
    fun inject(fragment: FragmentProducer)

    @Component.Builder
    interface BuilderFragmentProducer {
        @BindsInstance
        fun fragment(fragment: FragmentProducer): BuilderFragmentProducer
        fun activity(activity: MainActivityComponent): BuilderFragmentProducer
        fun build(): FragmentProducerComponent
    }
}

@Module
class FragmentProducerModule {

    @Fragment
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
abstract class Generator {
    @Fragment
    @Binds
    abstract fun generate(generator: ColorGeneratorImpl): ColorGenerator
}