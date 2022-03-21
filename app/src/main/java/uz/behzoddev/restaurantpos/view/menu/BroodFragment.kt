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
import uz.behzoddev.restaurantpos.databinding.FragmentBroodBinding
import uz.behzoddev.restaurantpos.presentation.store.BroodViewModel
import uz.behzoddev.restaurantpos.view.order_store.OrderStoreAdapter
import javax.inject.Inject

@AndroidEntryPoint
class BroodFragment : BaseFragment<FragmentBroodBinding>() {

    @Inject
    lateinit var broodAdapter: OrderStoreAdapter
    private val broodViewModel: BroodViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBroodBinding {
        return FragmentBroodBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBroodRecyclerView()
        observerBrood()
    }

    private fun initBroodRecyclerView() = with(binding) {
        broodRecyclerView.adapter = broodAdapter
        // When you call that function, the size (with and height) of recycler view
        // won’t change on the adapter insert/update/delete
        broodRecyclerView.setHasFixedSize(true)
    }

    private fun observerBrood() = lifecycleScope.launchWhenCreated {
        broodViewModel.broodState.collect { result ->
            when(result) {
                is ItemState.Loading -> {}
                is ItemState.Empty -> {}
                is ItemState.Success -> {
                    fetchAllBrood(result.data)
                }
                is ItemState.Failure -> {}
            }

        }
    }

    private fun fetchAllBrood(list: List<FoodItem>) = broodAdapter.diffUtil.submitList(list)
}