package uz.behzoddev.restaurantpos.domain.interactors.order

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder

class FetchOrdersBetweenInteractorImpl : FetchOrdersBetweenInteractor {

    override fun invoke(start: Long, end: Long): Flow<List<FoodOrder>> {
        TODO("Not yet implemented")
    }
}