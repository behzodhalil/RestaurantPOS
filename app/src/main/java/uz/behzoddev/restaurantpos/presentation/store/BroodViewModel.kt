package uz.behzoddev.restaurantpos.presentation.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.behzoddev.restaurantpos.common.coroutines.DispatcherProviders
import uz.behzoddev.restaurantpos.common.states.ItemState
import uz.behzoddev.restaurantpos.domain.interactors.item.FetchByBroodInteractor
import javax.inject.Inject

@HiltViewModel
class BroodViewModel @Inject constructor(
    private val fetchByBroodInteractor: FetchByBroodInteractor
) : ViewModel() {

    private var _broodState = MutableStateFlow<ItemState>(ItemState.Loading)
    val broodState: StateFlow<ItemState> get() = _broodState

    init {
        viewModelScope.launch {
            fetchByBroodInteractor.invoke().collect {
                when {
                    it.isNullOrEmpty() -> {
                        _broodState.value = ItemState.Empty
                    }
                    it.isNotEmpty() -> {
                        _broodState.value = ItemState.Success(it)
                    }
                    else -> {
                        _broodState.value = ItemState.Failure("Failure")
                    }
                }
            }
        }
    }
}