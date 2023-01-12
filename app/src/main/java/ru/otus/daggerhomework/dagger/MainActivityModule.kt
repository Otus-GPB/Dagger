package ru.otus.daggerhomework.dagger

import android.content.Context
import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.MainActivity
import javax.inject.Named


@Module
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

