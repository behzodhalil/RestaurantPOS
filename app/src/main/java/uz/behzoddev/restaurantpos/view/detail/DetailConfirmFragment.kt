package uz.behzoddev.restaurantpos.view.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.databinding.FragmentItemDetailConfirmBinding

@AndroidEntryPoint
class DetailConfirmFragment : BaseFragment<FragmentItemDetailConfirmBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentItemDetailConfirmBinding {
        return FragmentItemDetailConfirmBinding.inflate(inflater,container,false)
    }


}