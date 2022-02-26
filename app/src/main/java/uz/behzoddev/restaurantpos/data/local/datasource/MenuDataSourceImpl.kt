package uz.behzoddev.restaurantpos.data.local.datasource

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.dao.FoodMenuDao
import uz.behzoddev.restaurantpos.data.local.models.FoodMenu
import javax.inject.Inject

class MenuDataSourceImpl @Inject constructor(
    private val menuDao: FoodMenuDao
) : MenuDataSource {
    override suspend fun insertMenu(foodMenu: FoodMenu): Long {
        return menuDao.saveMenu(foodMenu)
    }

    override suspend fun updateMenu(foodMenu: FoodMenu): Int {
        return menuDao.updateMenu(foodMenu)
    }

    override suspend fun deleteMenu(foodMenu: FoodMenu): Int {
        return menuDao.delete(foodMenu)
    }

    override fun fetchAllMenus(): Flow<List<FoodMenu>> {
        return menuDao.fetchAllMenus()
    }

    override fun fetchMenuById(foodMenuId: Int): Flow<FoodMenu> {
        return menuDao.fetchMenuById(foodMenuId)
    }
}