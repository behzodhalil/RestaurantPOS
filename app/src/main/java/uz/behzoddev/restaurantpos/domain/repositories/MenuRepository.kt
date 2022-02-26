package uz.behzoddev.restaurantpos.domain.repositories

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodMenu

interface MenuRepository {
    suspend fun insertMenu(foodMenu: FoodMenu): Long
    suspend fun updateMenu(foodMenu: FoodMenu): Int
    suspend fun deleteMenu(foodMenu: FoodMenu): Int
    fun fetchAllMenus(): Flow<List<FoodMenu>>
    fun fetchMenuById(foodMenuId: Int): Flow<FoodMenu>
}