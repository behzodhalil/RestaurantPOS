package uz.behzoddev.restaurantpos.domain.interactors.order

import kotlinx.coroutines.withContext
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProviders
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder
import uz.behzoddev.restaurantpos.domain.repositories.OrderRepository
import javax.inject.Inject

class SaveOrderInteractorImpl @Inject constructor(
    private val orderRepository: OrderRepository,
    private val dispatcherProviders: DispatcherProviders
) : SaveOrderInteractor {

    override suspend fun invoke(foodOrder: FoodOrder) {
        return withContext(dispatcherProviders.io) {
            orderRepository.saveOrder(foodOrder)
        }
    }
}