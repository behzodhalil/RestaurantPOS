package uz.behzoddev.restaurantpos.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodStore

@Dao
interface FoodStoreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoodStore(foodStore: FoodStore): Long
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFoodStore(foodStore: FoodStore): Long
    @Delete()
    suspend fun deleteFoodStore(foodStore: FoodStore): Long
    @Query("SELECT * FROM food_store_table")
    fun fetchAllStores() : Flow<List<FoodStore>>
    @Query("SELECT * FROM food_store_table ORDER BY food_store_id =:foodStoreId")
    fun fetchAllStoresById(foodStoreId: Int) : Flow<FoodStore>

}