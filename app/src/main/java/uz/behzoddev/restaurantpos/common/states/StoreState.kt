package uz.behzoddev.restaurantpos.common.states

import uz.behzoddev.restaurantpos.data.local.models.FoodStore

sealed class StoreState {
    object Loading: StoreState()
    object Empty : StoreState()
    data class Success(val data: List<FoodStore>): StoreState()
    data class Failure(val message: String) : StoreState()
}
