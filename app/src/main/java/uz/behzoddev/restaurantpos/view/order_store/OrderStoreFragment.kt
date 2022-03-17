package uz.behzoddev.restaurantpos.view.order_store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.databinding.FragmentOrderStoreBinding


private const val CATEGORY = "category"

@AndroidEntryPoint
class OrderStoreFragment : BaseFragment<FragmentOrderStoreBinding>() {

    companion object {
        @JvmStatic
        fun newInstance(string: String) =
            OrderStoreFragment().apply {
                arguments = Bundle().apply {
                    putString(CATEGORY, string)
                }
            }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOrderStoreBinding {
        return FragmentOrderStoreBinding.inflate(inflater,container,false)
    }

}