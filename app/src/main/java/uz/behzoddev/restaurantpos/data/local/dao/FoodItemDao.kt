package uz.behzoddev.restaurantpos.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodItem

@Dao
interface FoodItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoodItem(foodItem: FoodItem): Long
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFoodItem(foodItem: FoodItem): Long
    @Delete
    suspend fun deleteFoodItem(foodItem: FoodItem): Long
    @Query("SELECT * FROM food_item_table")
    fun fetchAllFoodItems(): Flow<List<FoodItem>>
    @Query("SELECT * FROM food_item_table ORDER BY food_item_name")
    fun fetchAllFoodItemsByName(): Flow<List<FoodItem>>
}