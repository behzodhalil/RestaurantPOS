package uz.behzoddev.restaurantpos.common.states

import uz.behzoddev.restaurantpos.data.local.models.FoodItem

sealed class OrderState {
    object Loading: OrderState()
    object Empty: OrderState()
    data class Success(val data: FoodItem): OrderState()
    data class Failure(val message: String) : OrderState()
}