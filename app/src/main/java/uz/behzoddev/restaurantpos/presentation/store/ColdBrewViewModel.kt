package uz.behzoddev.restaurantpos.presentation.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.behzoddev.restaurantpos.common.states.ItemState
import uz.behzoddev.restaurantpos.domain.interactors.item.FetchByColdBrewInteractor
import javax.inject.Inject


@HiltViewModel
class ColdBrewViewModel @Inject constructor(
    private val fetchByColdBrewInteractor: FetchByColdBrewInteractor
) : ViewModel() {

    private var _coldBrewState = MutableStateFlow<ItemState>(ItemState.Loading)
    val coldBrewState: StateFlow<ItemState> get() = _coldBrewState

    init {
        viewModelScope.launch {
            fetchByColdBrewInteractor.invoke().collect {
                when {
                    it.isNullOrEmpty() -> {
                        _coldBrewState.value = ItemState.Empty
                    }
                    it.isNotEmpty() -> {
                        _coldBrewState.value = ItemState.Success(it)
                    }
                    else -> {
                        _coldBrewState.value = ItemState.Failure("Failure")
                    }
                }
            }
        }
    }
}