package uz.behzoddev.restaurantpos.domain.interactors.item

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.domain.repositories.ItemRepository
import javax.inject.Inject

class FetchByBroodImpl @Inject constructor(
    private val itemRepository: ItemRepository
) : FetchByBrood {
    override fun invoke(): Flow<List<FoodItem>> {
        return itemRepository.fetchByBrood()
    }
}