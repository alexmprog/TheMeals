package com.alexmprog.themeals.core.common.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Module
@ComponentScan
class DispatchersModule {

    @Single
    @Named("IoDispatcher")
    internal fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Single
    @Named("DefaultDispatcher")
    internal fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}