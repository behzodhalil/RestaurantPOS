package uz.behzoddev.restaurantpos.domain.interactors.order

import uz.behzoddev.restaurantpos.data.local.models.FoodOrder

interface SaveOrderInteractor {
    suspend operator fun invoke(foodOrder: FoodOrder)
}