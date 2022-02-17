package uz.behzoddev.restaurantpos.domain.interactors.store

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodStore

interface  FetchAllStoresInteractor {
    operator fun invoke(): Flow<List<FoodStore>>
}