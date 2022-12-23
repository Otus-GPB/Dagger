package ru.otus.daggerhomework.dagger

import android.content.Context
import androidx.lifecycle.MutableLiveData
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.ViewModelReceiver

@Component(dependencies = [MainActivityComponent::class], modules = [FragmentReceiverModule::class])
@Fragment
interface FragmentReceiverComponent {

    val fragmentReceiver: FragmentReceiver
    val viewModelProducer: ViewModelReceiver
    fun inject(fragment: FragmentReceiver)

    @Component.Builder
    interface BuilderFragmentReceiver {
        @BindsInstance
        fun fragment(fragmentReceiver: FragmentReceiver): BuilderFragmentReceiver
        fun activity(mainActivityComponent: MainActivityComponent): BuilderFragmentReceiver
        fun build(): FragmentReceiverComponent
    }
}

@Module
class FragmentReceiverModule {
    @Fragment
    @Provides
    fun provideViewModelReceiver(
        context: Context,
        liveData: MutableLiveData<Int>
    ): ViewModelReceiver {
        return ViewModelReceiver(context, liveData)
    }
}