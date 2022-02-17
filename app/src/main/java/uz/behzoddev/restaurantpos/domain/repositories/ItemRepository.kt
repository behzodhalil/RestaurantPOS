package uz.behzoddev.restaurantpos.domain.repositories

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodItem

interface ItemRepository {
    suspend fun insertFoodItem(foodItem: FoodItem): Long
    suspend fun updateFoodItem(foodItem: FoodItem): Long
    suspend fun deleteFoodItem(foodItem: FoodItem): Int
    fun fetchAllFoodItems(): Flow<List<FoodItem>>
    fun fetchAllFoodItemsByName(): Flow<List<FoodItem>>
}