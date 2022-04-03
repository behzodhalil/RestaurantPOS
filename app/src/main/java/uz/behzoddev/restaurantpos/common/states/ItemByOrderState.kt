package uz.behzoddev.restaurantpos.common.states

import uz.behzoddev.restaurantpos.data.local.models.FoodItem

sealed class ItemByOrderState {
    object Loading : ItemByOrderState()
    object Empty : ItemByOrderState()
    data class Success(val data: FoodItem) : ItemByOrderState()
    data class Failure(val message: String) : ItemByOrderState()
}