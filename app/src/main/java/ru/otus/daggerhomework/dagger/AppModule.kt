package ru.otus.daggerhomework.dagger

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.MainActivity
import javax.inject.Named



@Module
class Provider{
    @Provides
    fun provideContextApp(app: App): Context = app.applicationContext
}
