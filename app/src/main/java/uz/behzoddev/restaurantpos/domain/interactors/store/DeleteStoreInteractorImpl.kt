package uz.behzoddev.restaurantpos.domain.interactors.store

import kotlinx.coroutines.withContext
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProviders
import uz.behzoddev.restaurantpos.data.local.models.FoodStore
import uz.behzoddev.restaurantpos.domain.repositories.StoreRepository
import javax.inject.Inject

class DeleteStoreInteractorImpl @Inject constructor(
    private val storeRepository: StoreRepository,
    private val dispatcherProviders: DispatcherProviders
) : DeleteStoreInteractor {
    override suspend fun invoke(foodStore: FoodStore): Int {
        return withContext(dispatcherProviders.io) {
            storeRepository.deleteStore(foodStore)
        }
    }
}