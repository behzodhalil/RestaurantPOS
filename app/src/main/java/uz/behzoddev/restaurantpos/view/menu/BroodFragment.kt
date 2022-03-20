package uz.behzoddev.restaurantpos.view.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.databinding.FragmentBroodBinding

@AndroidEntryPoint
class BroodFragment : BaseFragment<FragmentBroodBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBroodBinding {
        return FragmentBroodBinding.inflate(inflater,container,false)
    }
}