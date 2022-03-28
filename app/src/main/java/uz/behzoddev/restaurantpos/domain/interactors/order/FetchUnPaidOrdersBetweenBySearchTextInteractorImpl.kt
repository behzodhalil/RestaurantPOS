package uz.behzoddev.restaurantpos.domain.interactors.order

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProviders
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder
import uz.behzoddev.restaurantpos.domain.repositories.OrderRepository
import javax.inject.Inject

class FetchUnPaidOrdersBetweenBySearchTextInteractorImpl @Inject constructor(
    private val orderRepository: OrderRepository,
    private val dispatcherProviders: DispatcherProviders
): FetchUnPaidOrdersBetweenBySearchTextInteractor {

    override fun invoke(searchText: String, start: Long, end: Long): Flow<List<FoodOrder>> {
        return orderRepository.fetchUnPaidOrdersBetweenBySearchText(searchText,start,end).flowOn(dispatcherProviders.io)
    }
}