package uz.behzoddev.restaurantpos.domain.interactors.item

import uz.behzoddev.restaurantpos.data.local.models.FoodItem

interface InsertItemInteractor {
    suspend operator fun invoke(foodItem: FoodItem): Long
}