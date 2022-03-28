package uz.behzoddev.restaurantpos.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.behzoddev.restaurantpos.data.local.datasource.*
import uz.behzoddev.restaurantpos.di.annotations.DatasourceBinds
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @DatasourceBinds
    @Singleton
    abstract fun provideItemDatasourceInstance(
        itemDataSourceImpl: ItemDataSourceImpl
    ): ItemDataSource

    @Binds
    @DatasourceBinds
    @Singleton
    abstract fun provideMenuDatasourceInstance(
        menuDataSourceImpl: MenuDataSourceImpl
    ): MenuDataSource

    @Binds
    @DatasourceBinds
    @Singleton
    abstract fun provideStoreDatasourceInstance(
        storeDataSourceImpl: StoreDataSourceImpl
    ): StoreDataSource

    @Binds
    @Singleton
    internal abstract fun provideOrderDatasourceInstance(orderDataSourceImpl: OrderDataSourceImpl): OrderDataSource
}