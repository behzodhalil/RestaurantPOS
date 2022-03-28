package uz.behzoddev.restaurantpos.domain.interactors.order

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder

interface FetchOrdersBySearchTextInteractor {
    operator fun invoke(searchText: String, amount: Int): Flow<List<FoodOrder>>
}