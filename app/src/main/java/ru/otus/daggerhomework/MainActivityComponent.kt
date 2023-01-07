package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Qualifier

@Qualifier
annotation class ActivityContext
@Qualifier
annotation class UiState
@Qualifier
annotation class MutableUiState

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {
    @Subcomponent.Factory
    interface Factory{
        fun create(
            @ActivityContext @BindsInstance activityContext: Context
        ): MainActivityComponent
    }

    fun fragmentReceiverComponent():FragmentReceiverComponent.Factory
    fun fragmentProducerComponent():FragmentProducerComponent.Factory
}

@Module(subcomponents = [FragmentReceiverComponent::class,
    FragmentProducerComponent::class])
class MainActivityModule {
    private val _uiState = MutableStateFlow(ColorChangeEvent(0))

    @Provides
    @UiState
    fun providesUiState(): StateFlow<ColorChangeEvent> {
        return _uiState
    }

    @Provides
    @MutableUiState
    fun providesMutableUiState(): MutableStateFlow<ColorChangeEvent> {
        return _uiState
    }
}