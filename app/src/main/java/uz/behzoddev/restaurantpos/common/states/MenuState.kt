package uz.behzoddev.restaurantpos.common.states

import uz.behzoddev.restaurantpos.data.local.models.FoodMenu

sealed class MenuState {
    object Loading : MenuState()
    object Empty : MenuState()
    data class Success(val data: List<FoodMenu>) : MenuState()
    data class Failure(val message: String): MenuState()
}
