package uz.behzoddev.restaurantpos.domain.interactors.item

import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.domain.repositories.ItemRepository
import javax.inject.Inject

class UpdateItemInteractorImpl @Inject constructor(
    private val itemRepository: ItemRepository
) : UpdateItemInteractor {
    override suspend fun invoke(foodItem: FoodItem): Int {
        return itemRepository.updateFoodItem(foodItem)
    }
}