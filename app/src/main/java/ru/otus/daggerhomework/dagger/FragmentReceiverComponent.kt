package ru.otus.daggerhomework.dagger

import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.ViewModelReceiver

@Component(dependencies = [MainActivityComponent::class], modules = [FragmentReceiverModule::class])
@FragmentScope
interface FragmentReceiverComponent {
    fun getFragment(): FragmentReceiver
    fun getviewModelProducer(): ViewModelReceiver
    fun inject(fragment: FragmentReceiver)


    @Component.Builder
    interface BuilderFragmentReceiver {
        @BindsInstance
        fun fragment(fragment: FragmentReceiver): BuilderFragmentReceiver
        fun activity(activity: MainActivityComponent): BuilderFragmentReceiver
        fun build(): FragmentReceiverComponent
    }

}