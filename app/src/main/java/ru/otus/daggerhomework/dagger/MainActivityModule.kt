package ru.otus.daggerhomework.dagger

import android.content.Context
import androidx.lifecycle.MutableLiveData
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.*
import javax.inject.Named


@Module(includes = [MainActivityBinder::class])
class MainActivityModule {
   @ActivitySingleScope
   @Provides
   fun sharedState():MutableLiveData<Int>{
      return MutableLiveData<Int>()
   }
}
@Module
interface MainActivityBinder{
   @Binds
   @Named("Activity")
   fun provideContext(activity: MainActivity): Context
   @Binds
   fun toGenerator(generator: ColorGeneratorImpl): ColorGenerator

}

