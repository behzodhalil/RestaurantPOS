package uz.behzoddev.restaurantpos.view.menu

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

const val COLD_BREW_COFFEE_INDEX = 0
const val ESPRESSO_INDEX = 1
const val TEA_INDEX = 2
const val FRAPPUCCINO_INDEX = 3
const val BROOD_INDEX = 4
const val JUICE_INDEX = 5

class MenuViewPagerAdapter(
    fragments: Fragment
) : FragmentStateAdapter(fragments) {


    private val fragments: Map<Int, () -> Fragment> = mapOf(
        COLD_BREW_COFFEE_INDEX to {
            ColdBrewCoffeeFragment()
        },
        ESPRESSO_INDEX to {
            EspressoFragment()
        },
        TEA_INDEX to {
            TeaFragment()
        },
        FRAPPUCCINO_INDEX to {
            FrappuccinoFragment()
        },
        BROOD_INDEX to {
            BroodFragment()
        },
        JUICE_INDEX to {
            JuiceFragment()
        }
    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}