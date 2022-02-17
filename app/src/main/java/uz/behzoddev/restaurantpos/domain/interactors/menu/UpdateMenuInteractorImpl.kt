package uz.behzoddev.restaurantpos.domain.interactors.menu

import uz.behzoddev.restaurantpos.data.local.models.FoodMenu
import uz.behzoddev.restaurantpos.di.annotations.RepositoryBinds
import uz.behzoddev.restaurantpos.domain.repositories.MenuRepository
import javax.inject.Inject

class UpdateMenuInteractorImpl @Inject constructor(
    @RepositoryBinds private val menuRepository: MenuRepository
) : UpdateMenuInteractor {
    override suspend fun invoke(foodMenu: FoodMenu): Int {
        return menuRepository.updateMenu(foodMenu)
    }
}