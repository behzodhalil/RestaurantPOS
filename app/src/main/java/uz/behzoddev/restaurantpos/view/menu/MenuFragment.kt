package uz.behzoddev.restaurantpos.view.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import uz.behzoddev.restaurantpos.R
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.databinding.FragmentMenuBinding
import uz.behzoddev.restaurantpos.utils.SliderTransformer
import uz.behzoddev.restaurantpos.view.order_store.OrderStoreAdapter

class MenuFragment : BaseFragment<FragmentMenuBinding>() {

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