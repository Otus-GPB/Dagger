package ru.otus.daggerhomework.dagger

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver
import javax.inject.Scope

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {
    val getAppContext: Context
    fun inject(fragment: FragmentReceiver)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance
                   fragment: FragmentReceiver,
                   activity: MainActivityComponent): FragmentReceiverComponent
    }
}
@Scope
annotation class FragmentScope