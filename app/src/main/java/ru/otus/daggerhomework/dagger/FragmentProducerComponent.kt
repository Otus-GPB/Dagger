package ru.otus.daggerhomework.dagger

import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.*
import javax.inject.Scope

@Component(dependencies = [MainActivityComponent::class], modules = [FragmentProducerModule::class, Implement::class])
@FragmentScope
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)
    fun getviewModelProducer(): ViewModelProducer

    @Component.Builder
    interface BuilderFragmentProducer {
        @BindsInstance
        fun fragment(fragment: FragmentProducer): BuilderFragmentProducer
        fun activity(activity: MainActivityComponent): BuilderFragmentProducer
        fun build(): FragmentProducerComponent
    }
}

@Scope
annotation class FragmentScope