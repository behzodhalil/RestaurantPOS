package uz.behzoddev.restaurantpos.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.behzoddev.restaurantpos.domain.interactors.item.*
import uz.behzoddev.restaurantpos.domain.interactors.menu.*
import uz.behzoddev.restaurantpos.domain.interactors.store.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class InteractorModule {

    @Binds
    @Singleton
    internal abstract fun provideDeleteItemInteractor(
        deleteItemInteractor: DeleteItemInteractorImpl
    ): DeleteItemInteractor

    @Binds
    @Singleton
    internal abstract fun provideFetchAllFoodItemsByNameInteractor(
        fetchAllFoodItemsByNameInteractor: FetchAllFoodItemsByNameInteractorImpl
    ) : FetchAllFoodItemsByNameInteractor

    @Binds
    @Singleton
    internal abstract fun provideFetchAllItemsInteractor(
        fetchAllItems: FetchAllItemsInteractorImpl
    ) : FetchAllItemsInteractor

    @Binds
    @Singleton
    internal abstract fun provideInsertItemInteractor(
        insertItemInteractor: InsertItemInteractorImpl
    ) : InsertItemInteractor

    @Binds
    @Singleton
    internal abstract fun provideUpdateItemInteractor(
        updateItemInteractor: UpdateItemInteractorImpl
    ) : UpdateItemInteractor

    @Binds
    @Singleton
    internal abstract fun provideDeleteMenuInteractor(
        deleteMenuInteractor: DeleteMenuInteractorImpl
    ) : DeleteMenuInteractor

    @Binds
    @Singleton
    internal abstract fun provideFetchAllMenuInteractor(
        fetchAllMenuInteractor: FetchAllMenusInteractorImpl
    ) : FetchAllMenusInteractor

    @Binds
    @Singleton
    internal abstract fun provideInsertMenuInteractor(
        insertMenuInteractor: InsertMenuInteractorImpl
    ) : InsertMenuInteractor

    @Binds
    @Singleton
    internal abstract fun provideUpdateMenuInteractor(
        updateMenuInteractor: UpdateMenuInteractorImpl
    ): UpdateMenuInteractor

    @Binds
    @Singleton
    internal abstract fun provideDeleteStoreInteractor(
        deleteStoreInteractor: DeleteStoreInteractorImpl
    ) : DeleteStoreInteractor

    @Binds
    @Singleton
    internal abstract fun provideFetchAllStoresByIdInteractor(
        fetchAllStoresByIdInteractor: FetchAllStoresByIdInteractorImpl
    ): FetchAllStoresByIdInteractor

    @Binds
    @Singleton
    internal abstract fun provideFetchAllStoresInteractor(
        fetchAllStoresInteractor: FetchAllStoresByIdInteractorImpl
    ): FetchAllStoresInteractor

    @Binds
    @Singleton
    internal abstract fun provideInsertStoreInteractor(
        insertStoreInteractor: InsertStoreInteractorImpl
    ) : InsertStoreInteractor

    @Binds
    @Singleton
    internal abstract fun provideUpdateStoreInteractor(
        updateStoreInteractor: UpdateStoreInteractorImpl
    ) : UpdateStoreInteractor
}