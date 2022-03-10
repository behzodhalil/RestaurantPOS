package uz.behzoddev.restaurantpos.view.menu_management

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import uz.behzoddev.restaurantpos.R
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.common.extensions.hide
import uz.behzoddev.restaurantpos.common.extensions.show
import uz.behzoddev.restaurantpos.common.states.ItemState
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.databinding.FragmentMenuManagementBinding
import uz.behzoddev.restaurantpos.presentation.menu.MenuManagementViewModel

@AndroidEntryPoint
class MenuManagementFragment : BaseFragment<FragmentMenuManagementBinding>() {

    private lateinit var menuManagementAdapter: MenuManagementAdapter
    private val menuManagementViewModel : MenuManagementViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMenuManagementBinding {
        return FragmentMenuManagementBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observerMenuManagement()
        onNavigateToAddMenu()
    }

    private fun setupRecyclerView() = with(binding) {
        menuManagementAdapter = MenuManagementAdapter()
        val menuManagementRV = layoutMenuManagement.recyclerViewMenuManagement
        menuManagementRV.adapter = menuManagementAdapter
    }

    private fun observerMenuManagement() = lifecycleScope.launchWhenStarted {
        menuManagementViewModel.itemState.collect { result ->
            when(result) {
                is ItemState.Loading -> {

                }
                is ItemState.Success -> {
                    showItems()
                    fetchAllItems(result.data)
                }
                is ItemState.Empty -> {
                    hideItems()
                }
                is ItemState.Failure -> {

                }
            }

        }
    }

    private fun fetchAllItems(list: List<FoodItem>) = menuManagementAdapter.differ.submitList(list)

    private fun showItems() = with(binding) {
        emptyLayout.hide()
        layoutMenuManagement.recyclerViewMenuManagement.show()
    }
    private fun hideItems() = with(binding) {
        layoutMenuManagement.recyclerViewMenuManagement.hide()
        emptyLayout.show()

    }
    private fun onNavigateToAddMenu() = with(binding) {
        btnInsert.setOnClickListener {
            findNavController().navigate(R.id.actionMenuManagementFragmentToAddMenuCategoryFragment)
        }
    }
}