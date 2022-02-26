package uz.behzoddev.restaurantpos.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProviders
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProvidersImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CoroutineModule {

    @Binds
    @Singleton
    abstract fun provideDispatcher(dispatcherProvidersImpl: DispatcherProvidersImpl): DispatcherProviders

}