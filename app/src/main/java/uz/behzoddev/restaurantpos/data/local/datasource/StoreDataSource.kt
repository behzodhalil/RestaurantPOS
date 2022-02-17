package uz.behzoddev.restaurantpos.data.local.datasource

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodStore


interface StoreDataSource {
    suspend fun insertStore(foodStore: FoodStore): Long
    suspend fun updateStore(foodStore: FoodStore): Int
    suspend fun deleteStore(foodStore: FoodStore): Int
    fun fetchAllStores(): Flow<List<FoodStore>>
    fun fetchAllStoresById(foodStoreId: Int): Flow<FoodStore>
}