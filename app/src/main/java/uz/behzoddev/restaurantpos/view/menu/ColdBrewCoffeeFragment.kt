package uz.behzoddev.restaurantpos.view.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.common.states.ItemState
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.databinding.FragmentColdBrewCoffeeBinding
import uz.behzoddev.restaurantpos.presentation.store.ColdBrewViewModel
import uz.behzoddev.restaurantpos.view.order_store.OrderStoreAdapter
import javax.inject.Inject

@AndroidEntryPoint
class ColdBrewCoffeeFragment : BaseFragment<FragmentColdBrewCoffeeBinding>() {

    @Inject
    lateinit var coldBrewAdapter: OrderStoreAdapter
    private val coldBrewViewModel: ColdBrewViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentColdBrewCoffeeBinding {
        return FragmentColdBrewCoffeeBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observerColdBrew()
    }

    private fun initRecyclerView() = with(binding) {
        coldBrewRecyclerView.adapter = coldBrewAdapter
    }

    private fun observerColdBrew() = lifecycleScope.launchWhenCreated {
        coldBrewViewModel.coldBrewState.collect { result ->
            when(result) {
                is ItemState.Loading -> {

                }
                is ItemState.Empty -> {

                }
                is ItemState.Failure -> {

                }
                is ItemState.Success -> {
                    fetchAllColdBrew(result.data)
                }
            }

        }
    }

    private fun fetchAllColdBrew(list: List<FoodItem>) = coldBrewAdapter.diffUtil.submitList(list)

}