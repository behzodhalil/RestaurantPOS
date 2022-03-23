package uz.behzoddev.restaurantpos.domain.repositories

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodItem

interface ItemRepository {
    suspend fun insertFoodItem(foodItem: FoodItem): Long
    suspend fun saveAllFoods(list: List<FoodItem>)
    suspend fun updateFoodItem(foodItem: FoodItem): Int
    suspend fun deleteFoodItem(foodItem: FoodItem): Int
    fun fetchAllFoodItems(): Flow<List<FoodItem>>
    fun fetchAllFoodItemsByName(): Flow<List<FoodItem>>
    fun fetchByColdBrew(): Flow<List<FoodItem>>
    fun fetchByBrood(): Flow<List<FoodItem>>
    fun fetchByEspresso(): Flow<List<FoodItem>>
    fun fetchByFrappucino(): Flow<List<FoodItem>>
    fun fetchByBlended(): Flow<List<FoodItem>>
    fun fetchByPhysio(): Flow<List<FoodItem>>
    fun fetchByTea(): Flow<List<FoodItem>>
    fun fetchByJuice(): Flow<List<FoodItem>>
    fun fetchById(id: Long): Flow<FoodItem>
}