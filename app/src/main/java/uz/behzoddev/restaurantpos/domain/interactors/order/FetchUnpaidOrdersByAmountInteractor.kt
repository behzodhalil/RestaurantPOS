package uz.behzoddev.restaurantpos.domain.interactors.order

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder

interface FetchUnpaidOrdersByAmountInteractor {
    operator fun invoke(amount: Int): Flow<List<FoodOrder>>
}