package uz.behzoddev.restaurantpos.data.local.datasource

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.dao.FoodStoreDao
import uz.behzoddev.restaurantpos.data.local.models.FoodStore
import javax.inject.Inject

class StoreDataSourceImpl @Inject constructor(
    private val storeDao: FoodStoreDao
) : StoreDataSource {
    override suspend fun insertStore(foodStore: FoodStore): Long {
        return storeDao.insertFoodStore(foodStore)
    }

    override suspend fun updateStore(foodStore: FoodStore): Long {
        return storeDao.updateFoodStore(foodStore)
    }

    override suspend fun deleteStore(foodStore: FoodStore): Long {
        return storeDao.deleteFoodStore(foodStore)
    }

    override fun fetchAllStores(): Flow<List<FoodStore>> {
        return storeDao.fetchAllStores()
    }

    override fun fetchAllStoresById(foodStoreId: Int): Flow<FoodStore> {
        return storeDao.fetchAllStoresById(foodStoreId)
    }
}