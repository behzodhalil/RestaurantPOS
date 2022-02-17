package uz.behzoddev.restaurantpos.domain.interactors.item

import uz.behzoddev.restaurantpos.data.local.models.FoodItem

interface DeleteItemInteractor {
    suspend operator fun invoke(foodItem: FoodItem): Long
}