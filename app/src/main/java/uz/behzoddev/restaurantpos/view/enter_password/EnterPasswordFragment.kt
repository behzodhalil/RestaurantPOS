package uz.behzoddev.restaurantpos.view.enter_password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.databinding.FragmentEnterPasswordToMenuSettingsBinding

class EnterPasswordFragment : BaseFragment<FragmentEnterPasswordToMenuSettingsBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEnterPasswordToMenuSettingsBinding {
        return FragmentEnterPasswordToMenuSettingsBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}