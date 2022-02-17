package uz.behzoddev.restaurantpos.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.behzoddev.restaurantpos.data.repositories.ItemRepositoryImpl
import uz.behzoddev.restaurantpos.data.repositories.MenuRepositoryImpl
import uz.behzoddev.restaurantpos.data.repositories.StoreRepositoryImpl
import uz.behzoddev.restaurantpos.di.annotations.RepositoryBinds
import uz.behzoddev.restaurantpos.domain.repositories.ItemRepository
import uz.behzoddev.restaurantpos.domain.repositories.MenuRepository
import uz.behzoddev.restaurantpos.domain.repositories.StoreRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    // Option 1 with internal keyword
    @Binds
    @Singleton
    internal abstract fun provideItemRepositoryInstance(
        itemRepositoryImpl: ItemRepositoryImpl
    ): ItemRepository

    // Option 2 with annotation class
    @Binds
    @RepositoryBinds
    @Singleton
    abstract fun provideMenuRepositoryInstance(
        menuRepositoryImpl: MenuRepositoryImpl
    ): MenuRepository

    @Binds
    @Singleton
    internal abstract fun provideStoreRepositoryInstance(
        storeRepositoryImpl: StoreRepositoryImpl
    ): StoreRepository
}