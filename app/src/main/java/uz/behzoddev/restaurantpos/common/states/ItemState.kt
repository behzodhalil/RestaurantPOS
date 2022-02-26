package uz.behzoddev.restaurantpos.common.states

import uz.behzoddev.restaurantpos.data.local.models.FoodItem

sealed class ItemState {
    object Loading : ItemState()
    object Empty : ItemState()
    data class Success(val data: List<FoodItem>) : ItemState()
    data class Failure(val message: String) : ItemState()
}
