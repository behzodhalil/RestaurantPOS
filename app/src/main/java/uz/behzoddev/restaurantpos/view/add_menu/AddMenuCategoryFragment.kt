package uz.behzoddev.restaurantpos.view.add_menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.behzoddev.restaurantpos.R
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.common.extensions.showToastShort
import uz.behzoddev.restaurantpos.data.local.models.FoodMenu
import uz.behzoddev.restaurantpos.databinding.FragmentAddMenuCategoryBinding
import uz.behzoddev.restaurantpos.presentation.menu.AddMenuViewModel

@AndroidEntryPoint
class AddMenuCategoryFragment : BaseFragment<FragmentAddMenuCategoryBinding>() {

    private val addViewModel: AddMenuViewModel by viewModels ()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAddMenuCategoryBinding {
        return FragmentAddMenuCategoryBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        insertMenu()
    }

    private fun insertMenu() = with(binding) {
        btnSave.setOnClickListener {
            addViewModel.insertMenu(fetchMenu()).run {
                showToastShort("Successfully inserted")
                findNavController().navigate(R.id.actionAddMenuCategoryFragmentToMenuManagementFragment)

            }
        }
    }
    private fun fetchMenu(): FoodMenu = binding.layoutMenuAdd.let {
        val menuTitle = it.tieMenuTitle.text.toString()
        val categoryName = it.tieMenuCategory.text.toString()


        return@fetchMenu FoodMenu(menuTitle,categoryName)


    }
}