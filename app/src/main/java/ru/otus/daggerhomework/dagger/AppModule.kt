package ru.otus.daggerhomework.dagger

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.App



@Module
class Provider{
    @Provides
    fun provideContextApp(app: App): Context = app.applicationContext
}
