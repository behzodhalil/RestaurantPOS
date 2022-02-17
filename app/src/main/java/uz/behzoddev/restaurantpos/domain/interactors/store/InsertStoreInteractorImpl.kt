package uz.behzoddev.restaurantpos.domain.interactors.store

import uz.behzoddev.restaurantpos.data.local.models.FoodStore
import uz.behzoddev.restaurantpos.domain.repositories.StoreRepository
import javax.inject.Inject

class InsertStoreInteractorImpl @Inject constructor(
    private val storeRepository: StoreRepository
) : InsertStoreInteractor {
    override suspend fun invoke(foodStore: FoodStore): Long {
        return storeRepository.insertStore(foodStore)
    }
}