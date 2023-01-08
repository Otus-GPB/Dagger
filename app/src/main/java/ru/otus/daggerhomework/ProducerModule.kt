package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module

@Module
interface ProducerModule {

    @ProducerScope
    @Binds
    fun colorGenerator(impl: ColorGeneratorImpl): ColorGenerator
}