package ru.otus.daggerhomework.dagger

import android.content.Context
import androidx.lifecycle.MutableLiveData
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.MainActivity
import javax.inject.Named
import javax.inject.Scope

@ActivityMain
@Component(dependencies = [ApplicationComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)
    val context: Context

    @Named("mainActivity")
    val getMainActivity: MainActivity
    val getMutableLivedata: MutableLiveData<Int>

    @Component.Factory
    interface FactoryMainActivityComponent {
        fun create(
            @BindsInstance mainActivity: MainActivity,
            appComponent: ApplicationComponent
        ): MainActivityComponent
    }
}

@Module
class MainActivityModule {
    @ActivityMain
    @Provides
    fun sharedState(): MutableLiveData<Int> {
        return MutableLiveData<Int>()
    }

    @Provides
    @Named("mainActivity")
    fun provideContext(mainActivity: MainActivity): Context = mainActivity
}