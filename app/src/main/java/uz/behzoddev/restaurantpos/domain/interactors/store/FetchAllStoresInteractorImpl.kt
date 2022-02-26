package uz.behzoddev.restaurantpos.domain.interactors.store

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProviders
import uz.behzoddev.restaurantpos.data.local.models.FoodStore
import uz.behzoddev.restaurantpos.domain.repositories.StoreRepository
import javax.inject.Inject

class FetchAllStoresInteractorImpl @Inject constructor(
   private val storeRepository: StoreRepository,
   private val dispatcherProviders: DispatcherProviders
) : FetchAllStoresInteractor {
    override fun invoke(): Flow<List<FoodStore>> {
        return storeRepository.fetchAllStores().flowOn(dispatcherProviders.io)
    }
}