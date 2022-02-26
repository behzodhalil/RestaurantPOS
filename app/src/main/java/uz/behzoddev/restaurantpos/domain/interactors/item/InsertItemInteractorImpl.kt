package uz.behzoddev.restaurantpos.domain.interactors.item

import kotlinx.coroutines.withContext
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProviders
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.domain.repositories.ItemRepository
import javax.inject.Inject

class InsertItemInteractorImpl @Inject constructor(
    private val itemRepository: ItemRepository,
    private val dispatcherProviders: DispatcherProviders
) : InsertItemInteractor {

    override suspend fun invoke(foodItem: FoodItem): Long {
        return withContext(dispatcherProviders.io) {
            itemRepository.insertFoodItem(foodItem)
        }
    }
}