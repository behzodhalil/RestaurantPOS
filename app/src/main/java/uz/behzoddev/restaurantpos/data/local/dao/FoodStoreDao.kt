package uz.behzoddev.restaurantpos.data.local.dao

import androidx.room.Dao

@Dao
interface FoodStoreDao {
    suspend fun deleteFoodStore()
    suspend fun insertFoodStore()
    fun fetchAllStores()
    suspend fun updateFoodStore()
}