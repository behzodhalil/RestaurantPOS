package uz.behzoddev.restaurantpos.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder

@Dao
interface FoodOrderDao {

    /**
        Fetch all orders from database.
        This method returns Flow<List<FoodOrder>>
     */
    @Query("SELECT * FROM food_order_table ORDER BY food_order_time_created")
    fun fetchAllOrders(): Flow<List<FoodOrder>>

    /**
        Fetch the last one order from database.
        This method returns Flow<FoodOrder>
     */
    @Query("SELECT * FROM food_order_table ORDER BY food_order_time_created DESC LIMIT 1")
    fun fetchLastOrder(): Flow<FoodOrder>

    /**
     *
     */
    @Query("SELECT * FROM food_order_table WHERE food_order_time_created BETWEEN :start AND :end AND food_order_is_valid != 0 ORDER BY food_order_time_created")
    fun fetchOrdersBetween(start:Long,end:Long): Flow<List<FoodOrder>>

    /**
     *
     */
    @Query("SELECT * FROM food_order_table WHERE food_order_time_created BETWEEN :start AND :end AND food_order_is_valid != 0 AND food_order_is_paid == 0 ORDER BY food_order_time_created")
    fun fetchUnPaidOrdersBetween(start: Long, end: Long): Flow<List<FoodOrder>>

    /**
     *
     */
    @Query(
        "SELECT * FROM (SELECT * FROM food_order_table WHERE food_order_time_created BETWEEN :start AND :end AND food_order_is_valid != 0 ORDER BY food_order_time_created) WHERE food_order_customer LIKE :searchText OR food_order_number LIKE :searchText"
    )
    fun fetchOrdersBetweenBySearchText(
        searchText: String,
        start: Long,
        end: Long
    ): Flow<List<FoodOrder>>

    /**
     *
     */
    @Query(
        "SELECT * FROM (SELECT * FROM food_order_table WHERE food_order_time_created BETWEEN :start AND :end AND food_order_is_valid != 0 AND food_order_is_paid == 0 ORDER BY food_order_time_created) WHERE food_order_customer LIKE :searchText OR food_order_number LIKE :searchText"
    )
    fun fetchUnPaidOrdersBetweenBySearchText(
        searchText: String,
        start: Long,
        end: Long
    ): Flow<List<FoodOrder>>

    /**
     *
     */
    @Query("SELECT * FROM food_order_table WHERE food_order_is_valid != 0 ORDER BY food_order_time_created DESC LIMIT :amount")
    fun fetchOrdersByAmount(amount: Int): Flow<List<FoodOrder>>

    /**
     *
     */
    @Query("SELECT * FROM (SELECT * FROM food_order_table WHERE food_order_is_valid != 0 ORDER BY food_order_time_created DESC LIMIT :amount) WHERE food_order_is_paid == 0")
    fun fetchUnpaidOrdersByAmount(amount: Int): Flow<List<FoodOrder>>

    /**
     *
     */
    @Query(
        "SELECT * FROM (SELECT * FROM food_order_table WHERE food_order_is_valid != 0 ORDER BY food_order_time_created DESC LIMIT :num) WHERE food_order_customer LIKE :searchText OR food_order_number LIKE :searchText"
    )
    fun fetchOrdersBySearchText(searchText: String, num: Int): Flow<List<FoodOrder>>

    /**
     *
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveOrder(foodOrder: FoodOrder)

    /**
     *
     */
    @Update
    suspend fun updateOrder(foodOrder: FoodOrder)

    /**
     *
     */
    @Query("DELETE FROM food_order_table")
    suspend fun deleteAllOrders()
}