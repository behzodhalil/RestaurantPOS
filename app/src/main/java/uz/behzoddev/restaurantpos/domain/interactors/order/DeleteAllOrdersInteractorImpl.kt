package uz.behzoddev.restaurantpos.domain.interactors.order

import kotlinx.coroutines.withContext
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProviders
import uz.behzoddev.restaurantpos.domain.repositories.OrderRepository
import javax.inject.Inject

class DeleteAllOrdersInteractorImpl @Inject constructor(
    private val orderRepository: OrderRepository,
    private val dispatcherProviders: DispatcherProviders
) : DeleteAllOrdersInteractor {

    override suspend fun invoke() {
        return withContext(dispatcherProviders.io) {
            orderRepository.deleteAllOrders()
        }
    }
}