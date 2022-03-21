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
import uz.behzoddev.restaurantpos.databinding.FragmentBlendedBinding
import uz.behzoddev.restaurantpos.presentation.store.BlendedViewModel
import uz.behzoddev.restaurantpos.view.order_store.OrderStoreAdapter
import javax.inject.Inject

@AndroidEntryPoint
class BlendedFragment : BaseFragment<FragmentBlendedBinding>() {

    @Inject
    lateinit var blendedAdapter: OrderStoreAdapter
    private val blendedViewModel : BlendedViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBlendedBinding {
        return FragmentBlendedBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBlendedRecyclerView()
        observerBlended()
    }

    private fun initBlendedRecyclerView() = with(binding) {
        blendedRecyclerView.adapter = blendedAdapter
        // When you call that function, the size (with and height) of recycler view
        // won’t change on the adapter insert/update/delete
        blendedRecyclerView.setHasFixedSize(true)
    }

    private fun observerBlended() = lifecycleScope.launchWhenCreated {
        blendedViewModel.blendedState.collect { result ->
            when(result) {
                is ItemState.Loading -> {}
                is ItemState.Empty -> {}
                is ItemState.Success -> {
                    fetchAllBlended(result.data)
                }
                is ItemState.Failure -> {}
            }
        }
    }
    private fun fetchAllBlended(list : List<FoodItem>) = blendedAdapter.diffUtil.submitList(list)
}