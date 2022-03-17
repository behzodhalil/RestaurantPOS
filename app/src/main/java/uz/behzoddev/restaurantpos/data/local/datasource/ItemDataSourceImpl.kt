package uz.behzoddev.restaurantpos.data.local.datasource

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.dao.FoodItemDao
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import javax.inject.Inject

class ItemDataSourceImpl @Inject constructor(
    private val itemDao: FoodItemDao
) : ItemDataSource {
    override suspend fun insertFoodItem(foodItem: FoodItem): Long {
        return itemDao.saveFoodItem(foodItem)
    }

    override suspend fun updateFoodItem(foodItem: FoodItem): Int {
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

    override fun fetchByColdBrew(): Flow<List<FoodItem>> {
        return itemDao.fetchByColdBrew()
    }

    override fun fetchByBrood(): Flow<List<FoodItem>> {
        return itemDao.fetchByBrood()
    }

    override fun fetchByEspresso(): Flow<List<FoodItem>> {
        return itemDao.fetchByEspresso()
    }

    override fun fetchByFrappucino(): Flow<List<FoodItem>> {
        return itemDao.fetchByFrappucino()
    }

    override fun fetchByBlended(): Flow<List<FoodItem>> {
        return itemDao.fetchByBlended()
    }

    override fun fetchByPhysio(): Flow<List<FoodItem>> {
        return itemDao.fetchByPhysio()
    }

    override fun fetchByTea(): Flow<List<FoodItem>> {
        return itemDao.fetchByTea()
    }

    override fun fetchByJuice(): Flow<List<FoodItem>> {
        return itemDao.fetchByJuice()
    }
}