package uz.behzoddev.restaurantpos.presentation.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.behzoddev.restaurantpos.common.states.ItemState
import uz.behzoddev.restaurantpos.domain.interactors.item.FetchByJuiceInteractor
import javax.inject.Inject

@HiltViewModel
class JuiceViewModel @Inject constructor(
    private val fetchByJuiceInteractor: FetchByJuiceInteractor
) : ViewModel() {

    private var _juiceState = MutableStateFlow<ItemState>(ItemState.Loading)
    val juiceState : StateFlow<ItemState> get() = _juiceState

    init {
        viewModelScope.launch {
            fetchByJuiceInteractor.invoke().collect {
                when {
                    it.isNullOrEmpty() -> {
                        _juiceState.value = ItemState.Empty
                    }
                    it.isNotEmpty() -> {
                        _juiceState.value = ItemState.Success(it)
                    }
                    else -> {
                        _juiceState.value = ItemState.Failure("Failure")
                    }
                }
            }
        }
    }


}