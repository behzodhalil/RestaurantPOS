package uz.behzoddev.restaurantpos.data.local.datasource

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodItem

interface ItemDataSource {
    suspend fun insertFoodItem(foodItem: FoodItem): Long
    suspend fun updateFoodItem(foodItem: FoodItem): Long
    suspend fun deleteFoodItem(foodItem: FoodItem): Long
    fun fetchAllFoodItems(): Flow<List<FoodItem>>
    fun fetchAllFoodItemsByName(): Flow<List<FoodItem>>
}