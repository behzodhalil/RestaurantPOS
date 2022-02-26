package uz.behzoddev.restaurantpos.domain.interactors.store

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProviders
import uz.behzoddev.restaurantpos.data.local.models.FoodStore
import uz.behzoddev.restaurantpos.domain.repositories.StoreRepository
import javax.inject.Inject

class FetchAllStoresByIdInteractorImpl @Inject constructor(
    private val storeRepository: StoreRepository,
    private val dispatcherProviders: DispatcherProviders
) : FetchAllStoresByIdInteractor {
    override fun invoke(foodStoreId: Int): Flow<FoodStore> {
        return storeRepository.fetchAllStoresById(foodStoreId).flowOn(dispatcherProviders.io)
    }
}