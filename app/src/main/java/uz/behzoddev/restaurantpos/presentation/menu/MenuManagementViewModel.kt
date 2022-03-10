package uz.behzoddev.restaurantpos.presentation.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.behzoddev.restaurantpos.common.states.ItemState
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.domain.interactors.item.DeleteItemInteractor
import uz.behzoddev.restaurantpos.domain.interactors.item.FetchAllItemsInteractor
import javax.inject.Inject

@HiltViewModel
class MenuManagementViewModel @Inject constructor(
    private val fetchAllItemsInteractor: FetchAllItemsInteractor,
    private val deleteItemInteractor: DeleteItemInteractor
) : ViewModel() {

    private val _itemState = MutableStateFlow<ItemState>(ItemState.Loading)
    val itemState: StateFlow<ItemState> = _itemState

    fun deleteFoodItem(foodItem: FoodItem) = viewModelScope.launch {
        deleteItemInteractor.invoke(foodItem)
    }

    init {
        viewModelScope.launch {
            fetchAllItemsInteractor.invoke().collect {
                if (it.isNullOrEmpty()) {
                    _itemState.value = ItemState.Empty
                } else {
                    _itemState.value = ItemState.Success(it)
                }
            }
        }
    }
}