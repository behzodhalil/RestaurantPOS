package uz.behzoddev.restaurantpos.domain.repositories

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder

interface OrderRepository {
    fun fetchAllOrders(): Flow<List<FoodOrder>>
    fun fetchLastOrder(): Flow<FoodOrder>
    fun fetchOrdersBetween(start: Long, end: Long): Flow<List<FoodOrder>>
    fun fetchUnPaidOrdersBetween(start: Long, end: Long): Flow<List<FoodOrder>>
    fun fetchOrdersBetweenBySearchText(
        searchText: String,
        start: Long,
        end: Long
    ): Flow<List<FoodOrder>>
    fun fetchUnPaidOrdersBetweenBySearchText(
        searchText: String,
        start: Long,
        end: Long
    ): Flow<List<FoodOrder>>
    fun fetchOrdersByAmount(amount: Int): Flow<List<FoodOrder>>
    fun fetchUnpaidOrdersByAmount(amount: Int): Flow<List<FoodOrder>>
    fun fetchOrdersBySearchText(searchText: String, num: Int): Flow<List<FoodOrder>>
    suspend fun saveOrder(foodOrder: FoodOrder)
    suspend fun updateOrder(foodOrder: FoodOrder)
    suspend fun deleteAllOrders()
}