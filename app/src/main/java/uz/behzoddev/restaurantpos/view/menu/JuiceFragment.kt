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
import uz.behzoddev.restaurantpos.databinding.FragmentJuiceBinding
import uz.behzoddev.restaurantpos.presentation.store.JuiceViewModel
import uz.behzoddev.restaurantpos.view.order_store.OrderStoreAdapter
import javax.inject.Inject

@AndroidEntryPoint
class JuiceFragment : BaseFragment<FragmentJuiceBinding>() {

    @Inject
    lateinit var juiceAdapter: OrderStoreAdapter
    private val juiceViewModel: JuiceViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentJuiceBinding {
        return FragmentJuiceBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initJuiceRecyclerView()
        observerJuice()
    }

    private fun initJuiceRecyclerView() = with(binding) {
        juiceRecyclerView.adapter = juiceAdapter
        // When you call that function, the size (with and height) of recycler view
        // won’t change on the adapter insert/update/delete
        juiceRecyclerView.setHasFixedSize(true)
    }

    private fun observerJuice() = lifecycleScope.launchWhenCreated {
        juiceViewModel.juiceState.collect { result ->
            when(result) {
                is ItemState.Loading -> {}
                is ItemState.Empty -> {

                }
                is ItemState.Failure -> {

                }
                is ItemState.Success -> {
                    fetchAllJuice(result.data)
                }
            }
        }

    }
    private fun fetchAllJuice(list: List<FoodItem>) = juiceAdapter.diffUtil.submitList(list)
}