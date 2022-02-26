package uz.behzoddev.restaurantpos.domain.interactors.menu

import kotlinx.coroutines.withContext
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProviders
import uz.behzoddev.restaurantpos.data.local.models.FoodMenu
import uz.behzoddev.restaurantpos.di.annotations.RepositoryBinds
import uz.behzoddev.restaurantpos.domain.repositories.MenuRepository
import javax.inject.Inject

class DeleteMenuInteractorImpl @Inject constructor(
    @RepositoryBinds private val menuRepository: MenuRepository,
    private val dispatcherProviders: DispatcherProviders
): DeleteMenuInteractor {
    override suspend fun invoke(foodMenu: FoodMenu): Int {
        return withContext(dispatcherProviders.io) {
            menuRepository.deleteMenu(foodMenu)
        }
    }
}