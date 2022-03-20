package uz.behzoddev.restaurantpos.presentation.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.behzoddev.restaurantpos.common.states.ItemState
import uz.behzoddev.restaurantpos.domain.interactors.item.FetchByTeaInteractor
import javax.inject.Inject

@HiltViewModel
class TeaViewModel @Inject constructor(
    private var fetchByTeaInteractor: FetchByTeaInteractor
) : ViewModel() {

    private var _teaState = MutableStateFlow<ItemState>(ItemState.Loading)
    val teaState: StateFlow<ItemState> get() = _teaState

    init {
        viewModelScope.launch {
            fetchByTeaInteractor.invoke().collect {
                when {
                    it.isNullOrEmpty() -> {
                        _teaState.value = ItemState.Empty
                    }
                    it.isNotEmpty() -> {
                        _teaState.value = ItemState.Success(it)
                    }
                    else -> {
                        _teaState.value = ItemState.Failure("Failure")
                    }
                }
            }
        }
    }

}