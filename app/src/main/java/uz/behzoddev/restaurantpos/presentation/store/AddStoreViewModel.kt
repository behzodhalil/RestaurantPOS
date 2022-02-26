package uz.behzoddev.restaurantpos.presentation.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.behzoddev.restaurantpos.data.local.models.FoodStore
import uz.behzoddev.restaurantpos.domain.interactors.store.InsertStoreInteractor
import javax.inject.Inject

@HiltViewModel
class AddStoreViewModel @Inject constructor(
    private val insertStoreInteractor: InsertStoreInteractor
) : ViewModel(){

    fun insertStore(foodStore: FoodStore) = viewModelScope.launch {
        insertStoreInteractor.invoke(foodStore)
    }
}