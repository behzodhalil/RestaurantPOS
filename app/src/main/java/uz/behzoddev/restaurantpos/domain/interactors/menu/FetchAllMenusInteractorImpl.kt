package uz.behzoddev.restaurantpos.domain.interactors.menu

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodMenu
import uz.behzoddev.restaurantpos.di.annotations.RepositoryBinds
import uz.behzoddev.restaurantpos.domain.repositories.MenuRepository
import javax.inject.Inject

class FetchAllMenusInteractorImpl @Inject constructor(
    @RepositoryBinds private val menuRepository: MenuRepository
) : FetchAllMenusInteractor {
    override fun invoke(): Flow<List<FoodMenu>> {
        TODO("Not yet implemented")
    }
}