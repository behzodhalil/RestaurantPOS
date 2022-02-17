package uz.behzoddev.restaurantpos.domain.interactors.item

import uz.behzoddev.restaurantpos.data.local.models.FoodItem

interface UpdateItemInteractor {
    suspend operator fun invoke(foodItem: FoodItem): Long
}