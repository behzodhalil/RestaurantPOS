package uz.behzoddev.restaurantpos.domain.interactors.item

import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.domain.repositories.ItemRepository
import javax.inject.Inject

class InsertItemInteractorImpl @Inject constructor(
    private val itemRepository: ItemRepository
) : InsertItemInteractor {
    override suspend fun invoke(foodItem: FoodItem): Long {
        return itemRepository.insertFoodItem(foodItem)
    }
}