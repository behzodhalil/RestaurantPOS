package uz.behzoddev.restaurantpos.domain.interactors.item

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.domain.repositories.ItemRepository
import javax.inject.Inject

class FetchByEspressoImpl @Inject constructor(
    private val itemRepository: ItemRepository
) : FetchByEspresso {

    override fun invoke(): Flow<List<FoodItem>> {
        return itemRepository.fetchByEspresso()
    }
}