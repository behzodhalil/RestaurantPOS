package uz.behzoddev.restaurantpos.presentation.store

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import uz.behzoddev.restaurantpos.common.states.ItemState
import uz.behzoddev.restaurantpos.domain.interactors.item.FetchAllItemsInteractor
import javax.inject.Inject

@HiltViewModel
class OrderStoreViewModel @Inject constructor(
    private val fetchAllItemsInteractor: FetchAllItemsInteractor
) {

    private var _orderStoreState = MutableStateFlow<ItemState>(ItemState.Loading)
    val orderStoreState: StateFlow<ItemState> get() = _orderStoreState

    init {

    }
}