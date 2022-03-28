package uz.behzoddev.restaurantpos.domain.interactors.order

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProviders
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder
import uz.behzoddev.restaurantpos.domain.repositories.OrderRepository
import javax.inject.Inject

class FetchLastOrderInteractorImpl @Inject constructor(
    private val orderRepository: OrderRepository,
    private val dispatcherProviders: DispatcherProviders
) : FetchLastOrderInteractor {

    override fun invoke(): Flow<FoodOrder> {
        return orderRepository.fetchLastOrder().flowOn(dispatcherProviders.io)
    }
}