package ru.otus.daggerhomework

import dagger.Component

@ReceiverScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [ReceiverModule::class]
)
interface FragmentReceiverComponent {

    @Component.Factory
    interface Factory {
        fun create(activityComponent: MainActivityComponent): FragmentReceiverComponent
    }

    fun inject(producer: FragmentReceiver)
}