package uz.behzoddev.restaurantpos.domain.interactors.item

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProviders
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.domain.repositories.ItemRepository
import javax.inject.Inject

class FetchByEspressoInteractorImpl @Inject constructor(
    private val itemRepository: ItemRepository,
    private val dispatcherProviders: DispatcherProviders
) : FetchByEspressoInteractor {

    override fun invoke(): Flow<List<FoodItem>> {
        return itemRepository.fetchByEspresso().flowOn(dispatcherProviders.io)
    }
}