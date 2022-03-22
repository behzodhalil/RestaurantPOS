package uz.behzoddev.restaurantpos.common.states

import uz.behzoddev.restaurantpos.data.local.models.FoodItem

sealed class DetailState {
    object Loading : DetailState()
    object Empty : DetailState()
    data class Success(val data: FoodItem): DetailState()
    data class Failure(val message: String): DetailState()
}
