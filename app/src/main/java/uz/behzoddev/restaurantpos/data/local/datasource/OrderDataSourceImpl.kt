package uz.behzoddev.restaurantpos.data.local.datasource

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.dao.FoodOrderDao
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder
import javax.inject.Inject

class OrderDataSourceImpl @Inject constructor(
    private val orderDao: FoodOrderDao
): OrderDataSource {

    override fun fetchAllOrders(): Flow<List<FoodOrder>> {
        return orderDao.fetchAllOrders()
    }

    override fun fetchLastOrder(): Flow<FoodOrder> {
        return orderDao.fetchLastOrder()
    }

    override fun fetchOrdersBetween(start: Long, end: Long): Flow<List<FoodOrder>> {
        return orderDao.fetchOrdersBetween(start,end)
    }

    override fun fetchUnPaidOrdersBetween(start: Long, end: Long): Flow<List<FoodOrder>> {
        return orderDao.fetchUnPaidOrdersBetween(start,end)
    }

    override fun fetchOrdersBetweenBySearchText(
        searchText: String,
        start: Long,
        end: Long
    ): Flow<List<FoodOrder>> {
        return orderDao.fetchOrdersBetweenBySearchText(searchText,start,end)
    }

    override fun fetchUnPaidOrdersBetweenBySearchText(
        searchText: String,
        start: Long,
        end: Long
    ): Flow<List<FoodOrder>> {
        return orderDao.fetchUnPaidOrdersBetweenBySearchText(searchText,start,end)
    }

    override fun fetchOrdersByAmount(amount: Int): Flow<List<FoodOrder>> {
        return orderDao.fetchOrdersByAmount(amount)
    }

    override fun fetchUnpaidOrdersByAmount(amount: Int): Flow<List<FoodOrder>> {
        return orderDao.fetchUnpaidOrdersByAmount(amount)
    }

    override fun fetchOrdersBySearchText(searchText: String, num: Int): Flow<List<FoodOrder>> {
        return orderDao.fetchOrdersBySearchText(searchText,num)
    }

    override suspend fun saveOrder(foodOrder: FoodOrder) {
        return orderDao.saveOrder(foodOrder)
    }

    override suspend fun updateOrder(foodOrder: FoodOrder) {
        return orderDao.updateOrder(foodOrder)
    }

    override suspend fun deleteAllOrders() {
        return orderDao.deleteAllOrders()
    }
}