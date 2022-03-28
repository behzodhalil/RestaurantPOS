package uz.behzoddev.restaurantpos.domain.interactors.order

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder

interface FetchOrdersBetweenBySearchTextInteractor {
    operator fun invoke(
        searchText: String,
        start: Long,
        end: Long
    ): Flow<List<FoodOrder>>
}