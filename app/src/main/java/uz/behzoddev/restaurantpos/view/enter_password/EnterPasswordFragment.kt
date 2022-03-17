package uz.behzoddev.restaurantpos.view.enter_password

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.behzoddev.restaurantpos.R
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
        onNavigateToMenuSettings()
    }


    private fun onNavigateToMenuSettings() = with(binding) {
        passwordView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable) {
                val password = passwordView.text.toString()
                if (password == "1234") {
                    findNavController().navigate(R.id.actionEnterPasswordFragmentToMenuSettingsFragment)
                } else {
                    passwordView.error = "Password is not full"
                }
            }
        })
    }
}