package uz.behzoddev.restaurantpos.domain.interactors.menu

import uz.behzoddev.restaurantpos.data.local.models.FoodMenu
import uz.behzoddev.restaurantpos.di.annotations.RepositoryBinds
import uz.behzoddev.restaurantpos.domain.repositories.MenuRepository
import javax.inject.Inject

class InsertMenuInteractorImpl @Inject constructor(
    @RepositoryBinds private val menuRepository: MenuRepository
) : InsertMenuInteractor {

    override fun invoke(foodMenu: FoodMenu): Long {
        TODO("Not yet implemented")
    }
}