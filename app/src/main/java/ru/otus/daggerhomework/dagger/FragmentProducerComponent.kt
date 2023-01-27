package ru.otus.daggerhomework.dagger

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.*

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {
    val getAppContext: Context
    val viewModelProducer:ViewModelProducer
    fun inject(fragment: FragmentProducer)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance
                   fragment: FragmentProducer,
                   activity: MainActivityComponent): FragmentProducerComponent
    }
}
