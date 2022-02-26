package uz.behzoddev.restaurantpos.domain.interactors.store

import kotlinx.coroutines.withContext
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProviders
import uz.behzoddev.restaurantpos.data.local.models.FoodStore
import uz.behzoddev.restaurantpos.domain.repositories.StoreRepository
import javax.inject.Inject

class InsertStoreInteractorImpl @Inject constructor(
    private val storeRepository: StoreRepository,
    private val dispatcherProviders: DispatcherProviders
) : InsertStoreInteractor {
    override suspend fun invoke(foodStore: FoodStore): Long {
        return withContext(dispatcherProviders.io) {
            storeRepository.insertStore(foodStore)
        }
    }
}