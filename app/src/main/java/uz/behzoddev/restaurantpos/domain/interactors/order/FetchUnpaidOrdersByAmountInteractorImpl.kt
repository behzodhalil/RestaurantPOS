package uz.behzoddev.restaurantpos.domain.interactors.order

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProviders
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder
import uz.behzoddev.restaurantpos.domain.repositories.OrderRepository
import javax.inject.Inject

class FetchUnpaidOrdersByAmountInteractorImpl @Inject constructor(
    private val orderRepository: OrderRepository,
    private val dispatcherProviders: DispatcherProviders
): FetchUnpaidOrdersByAmountInteractor {
    override fun invoke(amount: Int): Flow<List<FoodOrder>> {
        return orderRepository.fetchUnpaidOrdersByAmount(amount).flowOn(dispatcherProviders.io)
    }
}