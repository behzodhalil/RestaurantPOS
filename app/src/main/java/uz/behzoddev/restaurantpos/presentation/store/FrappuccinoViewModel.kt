package uz.behzoddev.restaurantpos.presentation.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.behzoddev.restaurantpos.common.states.ItemState
import uz.behzoddev.restaurantpos.domain.interactors.item.FetchByFrappucinoInteractor
import javax.inject.Inject

@HiltViewModel
class FrappuccinoViewModel @Inject constructor(
    private val fetchByFrappucinoInteractor: FetchByFrappucinoInteractor
) : ViewModel() {

    private var _frappuccinoState = MutableStateFlow<ItemState>(ItemState.Loading)
    val frappuccinoState : StateFlow<ItemState> get() = _frappuccinoState

    init {
        viewModelScope.launch {
            fetchByFrappucinoInteractor.invoke().collect {
                when {
                    it.isNullOrEmpty() -> {
                        _frappuccinoState.value = ItemState.Empty
                    }
                    it.isNotEmpty() -> {
                        _frappuccinoState.value = ItemState.Success(it)
                    }
                    else -> {
                        _frappuccinoState.value = ItemState.Failure("Failure")
                    }
                }
            }
        }
    }
}