package uz.behzoddev.restaurantpos.presentation.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.domain.interactors.item.InsertItemInteractor
import javax.inject.Inject

@HiltViewModel
class AddMenuViewModel @Inject constructor(
    private val insertItemInteractor: InsertItemInteractor
) : ViewModel() {

    fun insertMenu(foodItem: FoodItem) = viewModelScope.launch {
        insertItemInteractor(foodItem)
    }
}