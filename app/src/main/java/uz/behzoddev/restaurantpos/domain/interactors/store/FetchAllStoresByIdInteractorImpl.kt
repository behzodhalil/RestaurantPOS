package uz.behzoddev.restaurantpos.domain.interactors.store

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodStore
import uz.behzoddev.restaurantpos.domain.repositories.StoreRepository
import javax.inject.Inject

class FetchAllStoresByIdInteractorImpl @Inject constructor(
    private val storeRepository: StoreRepository
) : FetchAllStoresByIdInteractor {
    override fun invoke(foodStoreId: Int): Flow<FoodStore> {
        return storeRepository.fetchAllStoresById(foodStoreId)
    }
}