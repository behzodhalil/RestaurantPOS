package uz.behzoddev.restaurantpos.view.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import uz.behzoddev.restaurantpos.R
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.common.states.ItemState
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.databinding.FragmentEspresssoBinding
import uz.behzoddev.restaurantpos.presentation.store.EspressoViewModel
import uz.behzoddev.restaurantpos.view.order_store.OrderStoreAdapter
import javax.inject.Inject

@AndroidEntryPoint
class EspressoFragment : BaseFragment<FragmentEspresssoBinding>() {

    private val espressoAdapter = OrderStoreAdapter()
    private val espressoViewModel: EspressoViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEspresssoBinding {
        return FragmentEspresssoBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observerEspresso()
        onClickEspresso()
    }


    private fun initRecyclerView() = with(binding) {
        espressoRecyclerView.adapter = espressoAdapter
        // When you call that function, the size (with and height) of recycler view
        // won’t change on the adapter insert/update/delete
        espressoRecyclerView.setHasFixedSize(true)
    }

    private fun onClickEspresso() {
        espressoAdapter.setDetailClickListener {
            val bundle = Bundle().apply {
                putParcelable("food_item",it)
            }
            findNavController().navigate(R.id.actionMenuFragmentToDetailConfirmFragment,bundle)
        }
    }
    private fun observerEspresso() = lifecycleScope.launchWhenCreated {
        espressoViewModel.espressoState.collect {
            when(it) {
                is ItemState.Loading -> {

                }
                is ItemState.Empty -> {

                }
                is ItemState.Success -> {
                    fetchAllEspresso(it.data)
                }
                is ItemState.Failure -> {

                }
            }
        }
    }

    private fun fetchAllEspresso(list: List<FoodItem>) = espressoAdapter.diffUtil.submitList(list)

}