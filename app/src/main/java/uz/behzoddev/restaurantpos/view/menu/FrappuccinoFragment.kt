package uz.behzoddev.restaurantpos.view.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.databinding.FragmentFrappuccinoBinding
import uz.behzoddev.restaurantpos.presentation.store.FrappuccinoViewModel
import uz.behzoddev.restaurantpos.view.order_store.OrderStoreAdapter
import javax.inject.Inject

@AndroidEntryPoint
class FrappuccinoFragment : BaseFragment<FragmentFrappuccinoBinding>() {

    @Inject
    lateinit var frappuccinoAdapter: OrderStoreAdapter
    private val frappuccinoViewModel: FrappuccinoViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFrappuccinoBinding {
        return FragmentFrappuccinoBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initFrappuccinoRecyclerView() {

    }

    private fun observerFrappuccino() = lifecycleScope.launchWhenCreated {

    }
    private fun fetchAllFrappuccino(list: List<FoodItem>) = frappuccinoAdapter.diffUtil.submitList(list)
}