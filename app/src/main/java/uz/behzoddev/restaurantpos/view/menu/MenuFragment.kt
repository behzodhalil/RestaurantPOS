package uz.behzoddev.restaurantpos.view.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import uz.behzoddev.restaurantpos.R
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.databinding.FragmentMenuBinding

class MenuFragment : BaseFragment<FragmentMenuBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMenuBinding {
        return FragmentMenuBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.menuViewPager.adapter = MenuViewPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.menuViewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()
    }

    private fun getTabTitle(position: Int): String? =  when(position) {
        COLD_BREW_COFFEE_INDEX -> getString(R.string.cold_brew_coffee)
        BROOD_COFFEE_INDEX -> getString(R.string.brood_coffee)
        ESPRESSO_INDEX -> getString(R.string.espresso)
        FRAPPUCCINO_INDEX -> getString(R.string.frappucino)
        BLENDED_INDEX -> getString(R.string.blended)
        STARBUCKS_PHYSIO_INDEX -> getString(R.string.starbucks_physio)
        TEA_INDEX -> getString(R.string.tea)
        JUICE_INDEX -> getString(R.string.juice)
        else -> null
    }
}