package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Qualifier

@Qualifier
annotation class ActivityContext

@Subcomponent(modules = [MainActivitySubcomponents::class])
interface MainActivityComponent {
    @Subcomponent.Factory
    interface Factory{
        fun create(
            @BindsInstance uiState: MutableStateFlow<AppUiState>,
            @ActivityContext @BindsInstance activityContext: Context
        ): MainActivityComponent
    }

    fun fragmentReceiverComponent():FragmentReceiverComponent.Factory
    fun fragmentProducerComponent():FragmentProducerComponent.Factory

    fun inject(mainActivity: MainActivity)
}

@Module(subcomponents = [FragmentReceiverComponent::class,
    FragmentProducerComponent::class])
class MainActivitySubcomponents