package ru.otus.daggerhomework

import dagger.Component

@ProducerScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [ProducerModule::class]
)
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(activityComponent: MainActivityComponent): FragmentProducerComponent
    }

    fun inject(producer: FragmentProducer)
}