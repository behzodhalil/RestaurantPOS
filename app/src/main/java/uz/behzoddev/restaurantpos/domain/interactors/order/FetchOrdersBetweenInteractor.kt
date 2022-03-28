package uz.behzoddev.restaurantpos.domain.interactors.order

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder

interface FetchOrdersBetweenInteractor {
    operator fun invoke(start: Long, end: Long): Flow<List<FoodOrder>>
}