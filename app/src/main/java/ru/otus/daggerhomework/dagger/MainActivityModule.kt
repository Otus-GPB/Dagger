package ru.otus.daggerhomework.dagger

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.MainActivity
import javax.inject.Named


@Module()
class MainActivityModule {
   @ActivitySingleScope
   @Provides
   fun sharedState():MutableLiveData<Int>{
      return MutableLiveData<Int>()
   }
   @Provides
   @Named("Activity")
   fun provideContext(activity: MainActivity): Context = activity
}

