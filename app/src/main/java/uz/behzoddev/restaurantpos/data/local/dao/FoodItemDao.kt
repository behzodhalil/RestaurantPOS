package uz.behzoddev.restaurantpos.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodItem

/**
* Provides access to read/write operations on the food item table.
* Used by the data source to format query, insert, delete results for use in the UI.
*/

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