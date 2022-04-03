package uz.behzoddev.restaurantpos.presentation.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Index
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.behzoddev.restaurantpos.common.states.DetailState
import uz.behzoddev.restaurantpos.common.states.ItemByOrderState
import uz.behzoddev.restaurantpos.common.states.ItemState
import uz.behzoddev.restaurantpos.common.states.OrderState
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder
import uz.behzoddev.restaurantpos.data.local.models.FoodOrderItem
import uz.behzoddev.restaurantpos.domain.interactors.item.FetchByIdInteractor
import uz.behzoddev.restaurantpos.domain.interactors.order.FetchAllOrdersInteractor
import uz.behzoddev.restaurantpos.domain.interactors.order.SaveOrderInteractor
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val saveOrderInteractor: SaveOrderInteractor,
    private val fetchAllOrdersInteractor: FetchAllOrdersInteractor,
    private val fetchByIdInteractor: FetchByIdInteractor
) : ViewModel() {

    val orderItems = ArrayList<FoodOrderItem>()
    var subtotal = 0f
    var totalQuantity = 0

    private var _orderState = MutableStateFlow<OrderState>(OrderState.Loading)
    val orderState : StateFlow<OrderState> get() = _orderState

    private var _itemState = MutableStateFlow<ItemByOrderState>(ItemByOrderState.Loading)
    val itemState: StateFlow<ItemByOrderState> get() = _itemState

    fun fetchByIdFoodItem(id: Long)  = viewModelScope.launch {
        _itemState.value = ItemByOrderState.Loading
        fetchByIdInteractor.invoke(id).collect { result: FoodItem? ->
            if (result != null) {
                _itemState.value = ItemByOrderState.Success(result)
            } else {
                _itemState.value = ItemByOrderState.Failure("Failure")
            }
        }
    }
    fun saveOrder(foodOrder: FoodOrder) = viewModelScope.launch {
        saveOrderInteractor.invoke(foodOrder)
    }

    /*
    init {
        viewModelScope.launch {
            fetchAllOrdersInteractor.invoke().collect {
                when {
                    it.isNullOrEmpty() -> {
                        _orderState.value = OrderState.Empty
                    }
                    it.isNotEmpty() -> {
                        _orderState.value = OrderState.Success(it)
                    }
                    else -> {
                        _orderState.value = OrderState.Failure("Failure")
                    }
                }
            }
        }
    }

    */
}