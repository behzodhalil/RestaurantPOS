package uz.behzoddev.restaurantpos.domain.repositories

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodStore

interface StoreRepository {
    suspend fun insertStore(foodStore: FoodStore): Long
    suspend fun updateStore(foodStore: FoodStore): Long
    suspend fun deleteStore(foodStore: FoodStore): Long
    fun fetchAllStores(): Flow<List<FoodStore>>
    fun fetchAllStoresById(foodStoreId: Int): Flow<FoodStore>
}