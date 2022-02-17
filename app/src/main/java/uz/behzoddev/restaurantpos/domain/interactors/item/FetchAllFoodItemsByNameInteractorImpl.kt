package uz.behzoddev.restaurantpos.domain.interactors.item

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.domain.repositories.ItemRepository
import javax.inject.Inject

class FetchAllFoodItemsByNameInteractorImpl @Inject constructor(
    private val itemRepository: ItemRepository
) : FetchAllFoodItemsByNameInteractor {
    override fun invoke(): Flow<List<FoodItem>> {
        return itemRepository.fetchAllFoodItemsByName()
    }
}