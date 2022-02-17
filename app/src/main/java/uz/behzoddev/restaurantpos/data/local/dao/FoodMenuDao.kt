package uz.behzoddev.restaurantpos.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodMenu

/**
 * Provides access to read/write operations on the food menu table.
 * Used by the data source to format query, insert, delete results for use in the UI.
 */

@Dao
interface FoodMenuDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMenu(foodMenu: FoodMenu):Long
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateMenu(foodMenu: FoodMenu): Long
    @Delete
    suspend fun delete(foodMenu: FoodMenu): Int
    @Query("SELECT * FROM food_menu_table")
    fun fetchAllMenus() : Flow<List<FoodMenu>>
}