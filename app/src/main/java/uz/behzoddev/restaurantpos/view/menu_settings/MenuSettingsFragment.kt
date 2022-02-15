package uz.behzoddev.restaurantpos.view.menu_settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.behzoddev.restaurantpos.common.BaseFragment
import uz.behzoddev.restaurantpos.databinding.FragmentMenuSettingBinding

class MenuSettingsFragment : BaseFragment<FragmentMenuSettingBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMenuSettingBinding {
        return FragmentMenuSettingBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}