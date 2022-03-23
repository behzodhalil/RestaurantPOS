package uz.behzoddev.restaurantpos.domain.interactors.item

import uz.behzoddev.restaurantpos.data.local.models.FoodItem

interface SaveAllFoodsInteractor {
    suspend operator fun invoke(list: List<FoodItem>)
}