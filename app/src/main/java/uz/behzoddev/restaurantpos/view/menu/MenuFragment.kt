package uz.behzoddev.restaurantpos.view.menu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import uz.behzoddev.restaurantpos.R
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.common.extensions.debug
import uz.behzoddev.restaurantpos.common.extensions.showToastLong
import uz.behzoddev.restaurantpos.common.states.OrderState
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.data.local.models.FoodOrderItem
import uz.behzoddev.restaurantpos.databinding.FragmentMenuBinding
import uz.behzoddev.restaurantpos.presentation.store.OrderViewModel
import uz.behzoddev.restaurantpos.view.order.OrderItemAdapter
import uz.behzoddev.restaurantpos.view.order_store.OrderStoreAdapter


@AndroidEntryPoint
class MenuFragment : BaseFragment<FragmentMenuBinding>(),OrderStoreAdapter.OrderStoreListener {


    override fun onClickDetail(listener: FoodItem) {
        TODO("Not yet implemented")
    }

    private val orderAdapter = OrderItemAdapter()
    private lateinit var orderStoreAdapter : OrderStoreAdapter
    private val orderViewModel : OrderViewModel by activityViewModels()



    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMenuBinding {
        return FragmentMenuBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = MenuViewPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()
        click()
        initRecyclerView()
        observeOrder()
        }


    private fun click() {
    }
    private fun initRecyclerView() {
        binding.rvOrder.adapter = orderAdapter
    }


    private fun fetchById(id: Long) {

        orderViewModel.fetchByIdFoodItem(id)
    }

    private fun observeOrder() = lifecycleScope.launchWhenCreated {
        orderViewModel.orderState.collect { result ->
            when(result) {
                is OrderState.Loading -> {}
                is OrderState.Empty -> {}
                is OrderState.Success -> {
                    fetchAll(result.data)
                }
                is OrderState.Failure -> {}
            }

        }
    }

    internal fun addOrder(index: Int?, orderItem: FoodOrderItem) {
        orderViewModel.totalQuantity += orderItem.quantity
        orderViewModel.subtotal += orderItem.getAmount()
        for (it in orderViewModel.orderItems) {
            if (it.item == orderItem.item) {
                it.quantity += orderItem.quantity
                orderAdapter.notifyDataSetChanged()
                return
            }
        }
        if (index == null) {
            orderViewModel.orderItems.add(orderItem)
            orderViewModel.orderItems.sortBy { it.item.foodItemName }
        } else {
            orderViewModel.orderItems.add(index,orderItem)
            binding.rvOrder.adapter?.notifyItemInserted(index)
        }
    }
    private fun fetchAll(foodItem: FoodItem) = with(binding) {
        tvOrderName.text = foodItem.foodItemName
    }
    private fun getTabTitle(position: Int): String? =  when(position) {
        COLD_BREW_COFFEE_INDEX -> getString(R.string.cold_brew_coffee)
        ESPRESSO_INDEX -> getString(R.string.espresso)
        TEA_INDEX -> getString(R.string.tea)
        FRAPPUCCINO_INDEX -> getString(R.string.frappucino)
        BROOD_INDEX -> getString(R.string.brood_coffee)
        JUICE_INDEX -> getString(R.string.juice)
        // BLENDED_INDEX -> getString(R.string.blended)
        // STARBUCKS_PHYSIO_INDEX -> getString(R.string.starbucks_physio)
        else -> null
    }
}