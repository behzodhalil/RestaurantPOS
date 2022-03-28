package uz.behzoddev.restaurantpos.data.repositories

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.datasource.OrderDataSource
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder
import uz.behzoddev.restaurantpos.domain.repositories.OrderRepository
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val orderDataSource: OrderDataSource
): OrderRepository {
    override fun fetchAllOrders(): Flow<List<FoodOrder>> {
        return orderDataSource.fetchAllOrders()
    }

    override fun fetchLastOrder(): Flow<FoodOrder> {
        return orderDataSource.fetchLastOrder()
    }

    override fun fetchOrdersBetween(start: Long, end: Long): Flow<List<FoodOrder>> {
        return orderDataSource.fetchOrdersBetween(start,end)
    }

    override fun fetchUnPaidOrdersBetween(start: Long, end: Long): Flow<List<FoodOrder>> {
        return orderDataSource.fetchUnPaidOrdersBetween(start,end)
    }

    override fun fetchOrdersBetweenBySearchText(
        searchText: String,
        start: Long,
        end: Long
    ): Flow<List<FoodOrder>> {
        return orderDataSource.fetchOrdersBetweenBySearchText(searchText,start,end)
    }

    override fun fetchUnPaidOrdersBetweenBySearchText(
        searchText: String,
        start: Long,
        end: Long
    ): Flow<List<FoodOrder>> {
        return orderDataSource.fetchUnPaidOrdersBetweenBySearchText(searchText,start,end)
    }

    override fun fetchOrdersByAmount(amount: Int): Flow<List<FoodOrder>> {
        return orderDataSource.fetchOrdersByAmount(amount)
    }

    override fun fetchUnpaidOrdersByAmount(amount: Int): Flow<List<FoodOrder>> {
        return orderDataSource.fetchUnpaidOrdersByAmount(amount)
    }

    override fun fetchOrdersBySearchText(searchText: String, num: Int): Flow<List<FoodOrder>> {
        return orderDataSource.fetchOrdersBySearchText(searchText,num)
    }

    override suspend fun saveOrder(foodOrder: FoodOrder) {
        return orderDataSource.saveOrder(foodOrder)
    }

    override suspend fun updateOrder(foodOrder: FoodOrder) {
        return orderDataSource.updateOrder(foodOrder)
    }

    override suspend fun deleteAllOrders() {
        return orderDataSource.deleteAllOrders()
    }
}