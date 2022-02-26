package uz.behzoddev.restaurantpos.presentation.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.behzoddev.restaurantpos.data.local.models.FoodMenu
import uz.behzoddev.restaurantpos.domain.interactors.menu.InsertMenuInteractor
import javax.inject.Inject

@HiltViewModel
class AddMenuViewModel @Inject constructor(
    private val insertMenuInteractor: InsertMenuInteractor
) : ViewModel() {

    fun insertMenu(foodMenu: FoodMenu) = viewModelScope.launch {
        insertMenuInteractor.invoke(foodMenu)
    }
}