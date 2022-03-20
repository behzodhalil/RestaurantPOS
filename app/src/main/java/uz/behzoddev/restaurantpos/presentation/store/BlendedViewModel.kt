package uz.behzoddev.restaurantpos.presentation.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.behzoddev.restaurantpos.common.states.ItemState
import uz.behzoddev.restaurantpos.domain.interactors.item.FetchByBlendedInteractor
import javax.inject.Inject

@HiltViewModel
class BlendedViewModel @Inject constructor(
    private val fetchByBlendedInteractor: FetchByBlendedInteractor
) : ViewModel() {

    private var _blendedState = MutableStateFlow<ItemState>(ItemState.Loading)
    val blendedState : StateFlow<ItemState> get() = _blendedState

    init {
        viewModelScope.launch {
            fetchByBlendedInteractor.invoke().collect {
                when {
                    it.isNullOrEmpty() -> {
                        _blendedState.value = ItemState.Empty
                    }
                    it.isNotEmpty() -> {
                        _blendedState.value = ItemState.Success(it)
                    }
                    else -> {
                        _blendedState.value = ItemState.Failure("Failure")
                    }
                }
            }
        }
    }

}