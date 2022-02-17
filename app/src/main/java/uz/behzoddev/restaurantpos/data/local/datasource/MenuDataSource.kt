package uz.behzoddev.restaurantpos.data.local.datasource

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodMenu

interface MenuDataSource {
    suspend fun insertMenu(foodMenu: FoodMenu): Long
    suspend fun updateMenu(foodMenu: FoodMenu): Long
    suspend fun deleteMenu(foodMenu: FoodMenu): Int
    fun fetchAllMenus(): Flow<List<FoodMenu>>
}