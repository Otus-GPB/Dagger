package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.MutableLiveData
import dagger.Component
import dagger.Module
import dagger.Provides

@FragmentScope
@Component (dependencies = [MainActivityComponent::class], modules =
[FragmentReceiverModule::class])
interface FragmentReceiverComponent {

    @Component.Factory
    interface Factory {
        fun create(activityComponent: MainActivityComponent) : FragmentReceiverComponent
    }

    fun inject(fragmentReceiver: FragmentReceiver)
}

@Module
class FragmentReceiverModule {

    @FragmentScope
    @Provides
    fun provideViewModelReceiver(
        context : Context,
        mutableLiveData: MutableLiveData<Int>) : ViewModelReceiver = ViewModelReceiver(context,
        mutableLiveData)

}