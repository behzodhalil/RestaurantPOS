package uz.behzoddev.restaurantpos.data.repositories

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.datasource.MenuDataSource
import uz.behzoddev.restaurantpos.data.local.models.FoodMenu
import uz.behzoddev.restaurantpos.di.annotations.DatasourceBinds
import uz.behzoddev.restaurantpos.domain.repositories.MenuRepository
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    @DatasourceBinds private val menuDataSource: MenuDataSource
) : MenuRepository {
    override suspend fun insertMenu(foodMenu: FoodMenu): Long {
        return menuDataSource.insertMenu(foodMenu)
    }

    override suspend fun updateMenu(foodMenu: FoodMenu): Long {
        return menuDataSource.updateMenu(foodMenu)
    }

    override suspend fun deleteMenu(foodMenu: FoodMenu): Int {
        return menuDataSource.deleteMenu(foodMenu)
    }

    override fun fetchAllMenus(): Flow<List<FoodMenu>> {
        return menuDataSource.fetchAllMenus()
    }
}