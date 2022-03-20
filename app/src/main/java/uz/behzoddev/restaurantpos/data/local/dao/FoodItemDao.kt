package uz.behzoddev.restaurantpos.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.utils.*
import uz.behzoddev.restaurantpos.utils.CoffeeCategory.BLENDED
import uz.behzoddev.restaurantpos.utils.CoffeeCategory.BROOD_COFFEE
import uz.behzoddev.restaurantpos.utils.CoffeeCategory.COLD_BREW_COFFEE
import uz.behzoddev.restaurantpos.utils.CoffeeCategory.ESPRESSO
import uz.behzoddev.restaurantpos.utils.CoffeeCategory.JUICE
import uz.behzoddev.restaurantpos.utils.CoffeeCategory.STARBUCKS_PHYSIO
import uz.behzoddev.restaurantpos.utils.CoffeeCategory.TEA

/*
* Provides access to read/write operations on the food item table.
* Used by the data source to format query, insert, delete results for use in the UI.
*/

@Dao
interface FoodItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFoodItem(foodItem: FoodItem): Long
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFoodItem(foodItem: FoodItem): Int
    @Delete
    suspend fun deleteFoodItem(foodItem: FoodItem): Int
    @Query("SELECT * FROM food_item_table")
    fun fetchAllFoodItems(): Flow<List<FoodItem>>
    @Query("SELECT * FROM food_item_table ORDER BY food_item_name")
    fun fetchAllFoodItemsByName(): Flow<List<FoodItem>>
    @Query("SELECT * FROM food_item_table WHERE food_item_category = '$COLD_BREW_COFFEE' ORDER BY food_item_name")
    fun fetchByColdBrew(): Flow<List<FoodItem>>
    @Query("SELECT * FROM food_item_table WHERE food_item_category = '$BROOD_COFFEE' ORDER BY food_item_name")
    fun fetchByBrood(): Flow<List<FoodItem>>
    @Query("SELECT * FROM food_item_table WHERE food_item_category = '$ESPRESSO' ORDER BY food_item_category")
    fun fetchByEspresso(): Flow<List<FoodItem>>
    @Query("SELECT * FROM food_item_table WHERE food_item_category = '${CoffeeCategory.FRAPPUCCINO}' ORDER BY food_item_category")
    fun fetchByFrappucino(): Flow<List<FoodItem>>
    @Query("SELECT *FROM food_item_table WHERE food_item_category = '$BLENDED' ORDER BY food_item_name")
    fun fetchByBlended(): Flow<List<FoodItem>>
    @Query("SELECT * FROM food_item_table WHERE food_item_category = '$STARBUCKS_PHYSIO' ORDER BY food_item_name ")
    fun fetchByPhysio(): Flow<List<FoodItem>>
    @Query("SELECT * FROM food_item_table WHERE food_item_category = '$TEA' ORDER BY food_item_name ")
    fun fetchByTea(): Flow<List<FoodItem>>
    @Query("SELECT * FROM food_item_table WHERE food_item_category = '$JUICE' ORDER BY food_item_name ")
    fun fetchByJuice(): Flow<List<FoodItem>>
}