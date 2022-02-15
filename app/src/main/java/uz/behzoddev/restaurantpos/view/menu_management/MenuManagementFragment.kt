package uz.behzoddev.restaurantpos.view.menu_management

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.behzoddev.restaurantpos.common.BaseFragment
import uz.behzoddev.restaurantpos.databinding.FragmentMenuManagementBinding

class MenuManagementFragment : BaseFragment<FragmentMenuManagementBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMenuManagementBinding {
        return FragmentMenuManagementBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}