package ru.otus.daggerhomework.dagger

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.MainActivity
import javax.inject.Named
import javax.inject.Scope

//dependencies = [ApplicationComponent::class]
@ActivitySingleScope
@Component(modules = [MainActivityModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent {
    fun inject(activity: MainActivity)

    val getAppContext: Context
    @Named("Activity")val getMainActivity: MainActivity
    val getMutableLivedata:MutableLiveData<Int>


    @Component.Factory
    interface FactoryMainActivityComponent {
        fun create(@BindsInstance main: MainActivity, appComponent: ApplicationComponent): MainActivityComponent
    }
}

@Scope
annotation class ActivitySingleScope