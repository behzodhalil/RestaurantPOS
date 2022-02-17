package uz.behzoddev.restaurantpos.domain.interactors.store

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodStore

interface FetchAllStoresByIdInteractor {
    operator fun invoke(foodStoreId: Int): Flow<FoodStore>
}