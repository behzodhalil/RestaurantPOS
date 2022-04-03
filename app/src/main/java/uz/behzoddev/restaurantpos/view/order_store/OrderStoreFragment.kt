package uz.behzoddev.restaurantpos.view.order_store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.common.extensions.debug
import uz.behzoddev.restaurantpos.common.states.ItemState
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.databinding.FragmentOrderStoreBinding
import uz.behzoddev.restaurantpos.presentation.store.OrderStoreViewModel
import uz.behzoddev.restaurantpos.view.menu.FoodCategoryAdapter


const val COFFEE_CATEGORY = "category"

@AndroidEntryPoint
class OrderStoreFragment : BaseFragment<FragmentOrderStoreBinding>() {

    private lateinit var categoryAdapter: FoodCategoryAdapter

    private val orderStoreViewModel: OrderStoreViewModel by viewModels()

    companion object {
        @JvmStatic
        fun newInstance(string: String) =
            OrderStoreFragment().apply {
                arguments = Bundle().apply {
                    putString(COFFEE_CATEGORY, string)
                }
            }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOrderStoreBinding {
        return FragmentOrderStoreBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerOrderStore()
    }


    private fun initCategoryRecyclerView() = with(binding) {

    }

    private fun observerOrderStore() = lifecycleScope.launchWhenCreated {
        orderStoreViewModel.orderStoreState.collect { result ->
            when(result) {
                is ItemState.Loading -> {

                }
                is ItemState.Success -> {
                    debug { "${result.data}" }
                }
                is ItemState.Empty -> {

                }
                is ItemState.Failure -> {

                }
            }
        }
    }



}