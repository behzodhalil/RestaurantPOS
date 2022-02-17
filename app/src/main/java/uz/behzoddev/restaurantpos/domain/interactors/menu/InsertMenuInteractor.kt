package uz.behzoddev.restaurantpos.domain.interactors.menu

import uz.behzoddev.restaurantpos.data.local.models.FoodMenu

interface InsertMenuInteractor {
    suspend operator fun invoke(foodMenu: FoodMenu): Long
}