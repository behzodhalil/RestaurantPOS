package uz.behzoddev.restaurantpos.presentation.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.behzoddev.restaurantpos.common.states.ItemState
import uz.behzoddev.restaurantpos.domain.interactors.item.FetchByEspressoInteractor
import javax.inject.Inject

@HiltViewModel
class EspressoViewModel @Inject constructor(
    private var fetchByEspressoInteractor: FetchByEspressoInteractor
) : ViewModel() {

    private var _espressoState = MutableStateFlow<ItemState>(ItemState.Loading)
    val espressoState: StateFlow<ItemState> get() = _espressoState

    init {
        viewModelScope.launch {
            fetchByEspressoInteractor.invoke().collect {
                when {
                    it.isNullOrEmpty() -> {
                        _espressoState.value = ItemState.Empty
                    }
                    it.isNotEmpty() -> {
                        _espressoState.value = ItemState.Success(it)
                    }
                    else -> {
                        _espressoState.value = ItemState.Failure("Failure")
                    }
                }
            }
        }
    }
}