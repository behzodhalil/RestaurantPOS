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
        fetchAllStoresInteractor: FetchAllStoresInteractorImpl
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


    @Binds
    @Singleton
    internal abstract fun provideFetchByBlended(
        fetchByBlendedImpl: FetchByBlendedInteractorImpl
    ) : FetchByBlendedInteractor

    @Binds
    @Singleton
    internal abstract fun provideFetchByEspresso(
        fetchByEspressoImpl: FetchByEspressoInteractorImpl
    ) : FetchByEspressoInteractor

    @Binds
    @Singleton
    internal abstract fun provideFetchByBrood(
        fetchByBroodInteractorImpl: FetchByBroodInteractorImpl
    ): FetchByBroodInteractor

    @Binds
    @Singleton
    internal abstract fun provideFetchByColdBrew(
        fetchByColdBrewInteractorImpl: FetchByColdBrewInteractorImpl
    ): FetchByColdBrewInteractor

    @Binds
    @Singleton
    internal abstract fun provideFetchByFrappucino(
        fetchByFrappucinoImpl: FetchByFrappucinoInteractorImpl
    ): FetchByFrappucinoInteractor

    @Binds
    @Singleton
    internal abstract fun provideFetchByJuice(
        fetchByJuiceImpl: FetchByJuiceInteractorImpl
    ) : FetchByJuiceInteractor

    @Binds
    @Singleton
    internal abstract fun provideFetchByTea(
        fetchByTeaImpl: FetchByTeaInteractorImpl
    ) : FetchByTeaInteractor

    @Binds
    @Singleton
    internal abstract fun provideFetchByPhysio(
        fetchByPhysio: FetchByPhysioInteractorImpl
    ): FetchByPhysioInteractor
}