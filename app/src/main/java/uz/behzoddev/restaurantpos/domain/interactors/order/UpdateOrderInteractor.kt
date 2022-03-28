package uz.behzoddev.restaurantpos.domain.interactors.order

import uz.behzoddev.restaurantpos.data.local.models.FoodOrder

interface UpdateOrderInteractor {
    suspend operator fun invoke(foodOrder: FoodOrder)
}