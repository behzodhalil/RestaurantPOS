package uz.behzoddev.restaurantpos.domain.interactors.store

import uz.behzoddev.restaurantpos.data.local.models.FoodStore
import uz.behzoddev.restaurantpos.domain.repositories.StoreRepository
import javax.inject.Inject

class DeleteStoreInteractorImpl @Inject constructor(
    private val storeRepository: StoreRepository
) : DeleteStoreInteractor {
    override suspend fun invoke(foodStore: FoodStore): Long {
        return storeRepository.deleteStore(foodStore)
    }
}