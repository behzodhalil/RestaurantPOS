package uz.behzoddev.restaurantpos.domain.interactors.item

import kotlinx.coroutines.withContext
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProviders
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.domain.repositories.ItemRepository
import javax.inject.Inject

class UpdateItemInteractorImpl @Inject constructor(
    private val itemRepository: ItemRepository,
    private val dispatcherProvider: DispatcherProviders
) : UpdateItemInteractor {

    override suspend fun invoke(foodItem: FoodItem): Int {
        return withContext(dispatcherProvider.io) {
            itemRepository.updateFoodItem(foodItem)
        }
    }
}