package uz.behzoddev.restaurantpos.view.menu_management

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.behzoddev.restaurantpos.R
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.databinding.FragmentMenuManagementBinding

@AndroidEntryPoint
class MenuManagementFragment : BaseFragment<FragmentMenuManagementBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMenuManagementBinding {
        return FragmentMenuManagementBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onNavigateToAddMenu()
    }

    private fun onNavigateToAddMenu() = with(binding) {
        btnInsert.setOnClickListener {
            findNavController().navigate(R.id.actionMenuManagementFragmentToAddMenuCategoryFragment)
        }
    }
}