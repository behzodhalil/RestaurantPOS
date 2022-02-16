package uz.behzoddev.restaurantpos.data.local.datasource

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodStore


interface StoreDataSource {
    suspend fun insertStore(foodStore: FoodStore): Long
    suspend fun updateStore(foodStore: FoodStore): Long
    suspend fun deleteStore(foodStore: FoodStore): Long
    fun fetchAllStores(): Flow<List<FoodStore>>
    fun fetchAllStoresById(foodStoreId: Int): Flow<FoodStore>
}