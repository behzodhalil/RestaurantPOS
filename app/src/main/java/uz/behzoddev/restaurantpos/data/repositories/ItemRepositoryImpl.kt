package uz.behzoddev.restaurantpos.data.repositories

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.datasource.ItemDataSource
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.di.annotations.DatasourceBinds
import uz.behzoddev.restaurantpos.domain.repositories.ItemRepository
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    @DatasourceBinds private val itemDataSource: ItemDataSource
) : ItemRepository {
    override suspend fun insertFoodItem(foodItem: FoodItem): Long {
        return itemDataSource.insertFoodItem(foodItem)
    }

    override suspend fun updateFoodItem(foodItem: FoodItem): Int {
        return itemDataSource.updateFoodItem(foodItem)
    }

    override suspend fun deleteFoodItem(foodItem: FoodItem): Int {
        return itemDataSource.deleteFoodItem(foodItem)
    }

    override fun fetchAllFoodItems(): Flow<List<FoodItem>> {
        return itemDataSource.fetchAllFoodItems()
    }

    override fun fetchAllFoodItemsByName(): Flow<List<FoodItem>> {
        return itemDataSource.fetchAllFoodItemsByName()
    }

}