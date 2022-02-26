package uz.behzoddev.restaurantpos.domain.interactors.menu

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProviders
import uz.behzoddev.restaurantpos.data.local.models.FoodMenu
import uz.behzoddev.restaurantpos.di.annotations.RepositoryBinds
import uz.behzoddev.restaurantpos.domain.repositories.MenuRepository
import javax.inject.Inject

class FetchMenuByIdImpl @Inject constructor(
    @RepositoryBinds private val menuRepository: MenuRepository,
    private val dispatcherProviders: DispatcherProviders
    ) : FetchMenuById {
    override fun invoke(foodMenuId: Int): Flow<FoodMenu> {
        return menuRepository.fetchMenuById(foodMenuId).flowOn(dispatcherProviders.io)
    }
}