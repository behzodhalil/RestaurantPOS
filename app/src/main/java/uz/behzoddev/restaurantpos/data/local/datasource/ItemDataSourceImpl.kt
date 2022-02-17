package uz.behzoddev.restaurantpos.data.local.datasource

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.dao.FoodItemDao
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import javax.inject.Inject

class ItemDataSourceImpl @Inject constructor(
    private val itemDao: FoodItemDao
) : ItemDataSource {
    override suspend fun insertFoodItem(foodItem: FoodItem): Long {
        return itemDao.insertFoodItem(foodItem)
    }

    override suspend fun updateFoodItem(foodItem: FoodItem): Long {
        return itemDao.updateFoodItem(foodItem)
    }

    override suspend fun deleteFoodItem(foodItem: FoodItem): Int {
        return itemDao.deleteFoodItem(foodItem)
    }

    override fun fetchAllFoodItems(): Flow<List<FoodItem>> {
        return itemDao.fetchAllFoodItems()
    }

    override fun fetchAllFoodItemsByName(): Flow<List<FoodItem>> {
        return itemDao.fetchAllFoodItemsByName()
    }
}