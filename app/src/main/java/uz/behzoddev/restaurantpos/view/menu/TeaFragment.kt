package uz.behzoddev.restaurantpos.view.menu

import android.content.Intent
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
import uz.behzoddev.restaurantpos.databinding.FragmentTeaBinding
import uz.behzoddev.restaurantpos.presentation.store.TeaViewModel
import uz.behzoddev.restaurantpos.view.order_store.OrderStoreAdapter
import javax.inject.Inject

@AndroidEntryPoint
class TeaFragment : BaseFragment<FragmentTeaBinding>() {

    @Inject
    lateinit var teaAdapter : OrderStoreAdapter
    private val teaViewModel: TeaViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTeaBinding {
        return FragmentTeaBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTeaRecyclerView()
        observerTea()
    }

    private fun initTeaRecyclerView() = with(binding) {
        teaRecyclerView.adapter = teaAdapter
        // When you call that function, the size (with and height) of recycler view
        // won’t change on the adapter insert/update/delete
        teaRecyclerView.setHasFixedSize(true)
    }

    private fun observerTea() = lifecycleScope.launchWhenCreated {
        teaViewModel.teaState.collect { result ->
            when(result) {
                is ItemState.Loading -> {}
                is ItemState.Empty -> {}
                is ItemState.Success -> {
                    fetchAllTea(result.data)
                }
                is ItemState.Failure -> {}
            }
        }
    }


    private fun fetchAllTea(list: List<FoodItem>) = teaAdapter.diffUtil.submitList(list)
}