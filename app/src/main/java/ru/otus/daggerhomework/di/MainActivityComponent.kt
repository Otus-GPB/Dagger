package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.MutableLiveData
import dagger.BindsInstance
import dagger.Subcomponent
import ru.otus.daggerhomework.MainActivity
import javax.inject.Named

@ActivityScope
@Subcomponent(modules = [ObserverModule::class, ActivitySubcomponentsModule::class])
interface MainActivityComponent {
    @Subcomponent.Factory
    interface Factory{
        fun create(@Named("ActivityContext")@BindsInstance context: Context): MainActivityComponent
    }

    fun fragmentProducerComponent(): FragmentProducerComponent.Factory
    fun fragmentReceiverComponent(): FragmentReceiverComponent.Factory

}