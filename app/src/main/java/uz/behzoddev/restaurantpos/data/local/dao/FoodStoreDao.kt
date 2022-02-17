package uz.behzoddev.restaurantpos.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodStore

/**
 * Provides access to read/write operations on the food store table.
 * Used by the data source to format query, insert, delete results for use in the UI.
 */

@Dao
interface FoodStoreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFoodStore(foodStore: FoodStore): Long
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFoodStore(foodStore: FoodStore): Int
    @Delete()
    suspend fun deleteFoodStore(foodStore: FoodStore): Int
    @Query("SELECT * FROM food_store_table")
    fun fetchAllStores() : Flow<List<FoodStore>>
    @Query("SELECT * FROM food_store_table ORDER BY food_store_id =:foodStoreId")
    fun fetchAllStoresById(foodStoreId: Int) : Flow<FoodStore>

}