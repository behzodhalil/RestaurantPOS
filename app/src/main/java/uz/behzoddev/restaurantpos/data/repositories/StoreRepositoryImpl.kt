package uz.behzoddev.restaurantpos.data.repositories

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.datasource.StoreDataSource
import uz.behzoddev.restaurantpos.data.local.models.FoodStore
import uz.behzoddev.restaurantpos.di.annotations.DatasourceBinds
import uz.behzoddev.restaurantpos.domain.repositories.StoreRepository
import javax.inject.Inject

class StoreRepositoryImpl @Inject constructor(
    @DatasourceBinds private val storeDataSource: StoreDataSource
) : StoreRepository {

    override suspend fun insertStore(foodStore: FoodStore): Long {
        return storeDataSource.insertStore(foodStore)
    }

    override suspend fun updateStore(foodStore: FoodStore): Long {
        return storeDataSource.updateStore(foodStore)
    }

    override suspend fun deleteStore(foodStore: FoodStore): Long {
        return storeDataSource.deleteStore(foodStore)
    }

    override fun fetchAllStores(): Flow<List<FoodStore>> {
        return storeDataSource.fetchAllStores()
    }

    override fun fetchAllStoresById(foodStoreId: Int): Flow<FoodStore> {
        return storeDataSource.fetchAllStoresById(foodStoreId)
    }
}