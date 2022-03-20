package uz.behzoddev.restaurantpos.presentation.store

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.behzoddev.restaurantpos.common.states.ItemState
import uz.behzoddev.restaurantpos.domain.interactors.item.*
import uz.behzoddev.restaurantpos.utils.CoffeeCategory
import uz.behzoddev.restaurantpos.utils.CoffeeCategory.BLENDED
import uz.behzoddev.restaurantpos.utils.CoffeeCategory.BROOD_COFFEE
import uz.behzoddev.restaurantpos.utils.CoffeeCategory.COLD_BREW_COFFEE
import uz.behzoddev.restaurantpos.utils.CoffeeCategory.ESPRESSO
import uz.behzoddev.restaurantpos.utils.CoffeeCategory.FRAPPUCCINO
import uz.behzoddev.restaurantpos.utils.CoffeeCategory.JUICE
import uz.behzoddev.restaurantpos.utils.CoffeeCategory.STARBUCKS_PHYSIO
import uz.behzoddev.restaurantpos.utils.CoffeeCategory.TEA
import uz.behzoddev.restaurantpos.view.order_store.COFFEE_CATEGORY
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class OrderStoreViewModel @Inject constructor(
    private val fetchAllItemsInteractor: FetchAllItemsInteractor,
    private val fetchByBlendedInteractor: FetchByBlendedInteractor,
    private val fetchByBroodInteractor: FetchByBroodInteractor,
    private val fetchByColdBrewInteractor: FetchByColdBrewInteractor,
    private val fetchByFrappucinoInteractor: FetchByFrappucinoInteractor,
    private val fetchByEspressoInteractor: FetchByEspressoInteractor,
    private val fetchByJuiceInteractor: FetchByJuiceInteractor,
    private val fetchByPhysioInteractor: FetchByPhysioInteractor,
    private val fetchByTeaInteractor: FetchByTeaInteractor,
) : ViewModel() {

    private var _orderStoreState = MutableStateFlow<ItemState>(ItemState.Loading)
    val orderStoreState: StateFlow<ItemState> get() = _orderStoreState
    val currentTopic: MutableLiveData<String> by lazy {
        MutableLiveData<String>().defaultTopic(COLD_BREW_COFFEE)
    }
    init {
        viewModelScope.launch {
            when(COFFEE_CATEGORY) {
                COLD_BREW_COFFEE -> {
                    fetchByColdBrewInteractor.invoke().collect {
                        if (it.isNullOrEmpty()) {
                            _orderStoreState.value = ItemState.Empty
                        } else {
                            _orderStoreState.value = ItemState.Success(it)
                        }
                    }
                }

                BROOD_COFFEE -> {
                    fetchByBroodInteractor.invoke().collect {
                        if (it.isNullOrEmpty()) {
                            _orderStoreState.value = ItemState.Empty
                        } else {
                            _orderStoreState.value = ItemState.Success(it)
                        }
                    }
                }

                ESPRESSO -> {
                    fetchByEspressoInteractor.invoke().collect {
                        if (it.isNullOrEmpty()) {
                            _orderStoreState.value = ItemState.Empty
                        } else {
                            _orderStoreState.value = ItemState.Success(it)
                        }
                    }
                }

                FRAPPUCCINO -> {
                    fetchByFrappucinoInteractor.invoke().collect {
                        if (it.isNullOrEmpty()) {
                            _orderStoreState.value = ItemState.Empty
                        } else {
                            _orderStoreState.value = ItemState.Success(it)
                        }
                    }
                }

                BLENDED -> {
                    fetchByBlendedInteractor.invoke().collect {
                        if (it.isNullOrEmpty()) {
                            _orderStoreState.value = ItemState.Empty
                        } else {
                            _orderStoreState.value = ItemState.Success(it)
                        }
                    }
                }

                STARBUCKS_PHYSIO -> {
                    fetchByPhysioInteractor.invoke().collect {
                        if (it.isNullOrEmpty()) {
                            _orderStoreState.value = ItemState.Empty
                        } else {
                            _orderStoreState.value = ItemState.Success(it)
                        }
                    }
                }

                JUICE -> {
                    fetchByJuiceInteractor.invoke().collect {
                        if (it.isNullOrEmpty()) {
                            _orderStoreState.value = ItemState.Empty
                        } else {
                            _orderStoreState.value = ItemState.Success(it)
                        }
                    }
                }

                TEA -> {
                    fetchByTeaInteractor.invoke().collect {
                        when {
                            it.isNullOrEmpty() -> {
                                _orderStoreState.value = ItemState.Empty
                            }
                            it.isNotEmpty() -> {
                                _orderStoreState.value = ItemState.Success(it)
                            }
                            else -> {
                                _orderStoreState.value = ItemState.Failure("Failure")
                            }
                        }
                    }
                }



            }
        }
    }
    // set default topic when opening
    private fun <T : Any?> MutableLiveData<T>.defaultTopic(initialValue: T) =
        apply { setValue(initialValue) }
}