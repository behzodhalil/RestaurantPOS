package uz.behzoddev.restaurantpos.domain.interactors.order

import kotlinx.coroutines.flow.Flow
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProviders
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder
import uz.behzoddev.restaurantpos.domain.repositories.OrderRepository
import javax.inject.Inject

class FetchOrdersBySearchTextInteractorImpl @Inject constructor(
    private val orderRepository: OrderRepository,
    private val dispatcherProviders: DispatcherProviders
) : FetchOrdersBySearchTextInteractor {

    override fun invoke(searchText: String, amount: Int): Flow<List<FoodOrder>> {
        return orderRepository.fetchOrdersBySearchText(searchText,amount)
    }
}