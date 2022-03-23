package uz.behzoddev.restaurantpos.presentation.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.behzoddev.restaurantpos.common.states.DetailState
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.domain.interactors.item.FetchByIdInteractor
import javax.inject.Inject

@HiltViewModel
class DetailMenuViewModel @Inject constructor(
    private val fetchByIdInteractor: FetchByIdInteractor
) : ViewModel() {

    private var _detailState = MutableStateFlow<DetailState>(DetailState.Loading)
    val detailState: StateFlow<DetailState> get() = _detailState

    fun fetchById(id: Long) = viewModelScope.launch {
        _detailState.value = DetailState.Loading
        fetchByIdInteractor.invoke(id).collect { result: FoodItem? ->
            if (result != null) {
                _detailState.value = DetailState.Success(result)
            } else {
                _detailState.value = DetailState.Failure("Failure")
            }
        }
        }
}