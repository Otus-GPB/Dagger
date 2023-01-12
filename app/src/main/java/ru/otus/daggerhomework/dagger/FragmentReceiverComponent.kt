package ru.otus.daggerhomework.dagger

import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.ViewModelReceiver
import javax.inject.Scope

@FragmentScope
@Component(dependencies = [MainActivityComponent::class], modules = [FragmentReceiverModule::class])
interface FragmentReceiverComponent {
    fun inject(fragment: FragmentReceiver)


    @Component.Builder
    interface BuilderFragmentReceiver {
        @BindsInstance
        fun fragment(fragment: FragmentReceiver): BuilderFragmentReceiver
        fun activity(activity: MainActivityComponent): BuilderFragmentReceiver
        fun build(): FragmentReceiverComponent
    }

}
@Scope
annotation class FragmentScope