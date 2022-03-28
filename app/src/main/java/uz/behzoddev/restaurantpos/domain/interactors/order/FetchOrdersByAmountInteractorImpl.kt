package uz.behzoddev.restaurantpos.domain.interactors.order

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder

class FetchOrdersByAmountInteractorImpl: FetchOrdersByAmountInteractor {
    override fun invoke(amount: Int): Flow<List<FoodOrder>> {
        TODO("Not yet implemented")
    }
}