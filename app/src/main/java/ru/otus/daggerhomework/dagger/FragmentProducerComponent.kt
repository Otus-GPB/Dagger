package ru.otus.daggerhomework.dagger

import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.*
import javax.inject.Scope

@FragmentScope
@Component(dependencies = [MainActivityComponent::class], modules = [FragmentProducerModule::class, Implement::class])
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)

    @Component.Builder
    interface BuilderFragmentProducer {
        @BindsInstance
        fun fragment(fragment: FragmentProducer): BuilderFragmentProducer
        fun activity(activity: MainActivityComponent): BuilderFragmentProducer
        fun build(): FragmentProducerComponent
    }
}
