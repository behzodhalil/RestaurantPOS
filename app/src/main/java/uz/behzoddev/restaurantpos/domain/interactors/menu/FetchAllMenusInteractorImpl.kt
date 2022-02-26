package uz.behzoddev.restaurantpos.domain.interactors.menu

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProviders
import uz.behzoddev.restaurantpos.data.local.models.FoodMenu
import uz.behzoddev.restaurantpos.di.annotations.RepositoryBinds
import uz.behzoddev.restaurantpos.domain.repositories.MenuRepository
import javax.inject.Inject

class FetchAllMenusInteractorImpl @Inject constructor(
    @RepositoryBinds private val menuRepository: MenuRepository,
    private val dispatcherProvider: DispatcherProviders
) : FetchAllMenusInteractor {
    override fun invoke(): Flow<List<FoodMenu>> {
        return menuRepository.fetchAllMenus().flowOn(dispatcherProvider.io)
    }
}