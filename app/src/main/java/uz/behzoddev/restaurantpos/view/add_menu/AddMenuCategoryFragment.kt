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
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.databinding.FragmentAddItemBinding
import uz.behzoddev.restaurantpos.presentation.menu.AddMenuViewModel

@AndroidEntryPoint
class AddMenuCategoryFragment : BaseFragment<FragmentAddItemBinding>() {

    private val addViewModel: AddMenuViewModel by viewModels ()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAddItemBinding {
        return FragmentAddItemBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        insertMenu()
    }

    private fun insertMenu() = with(binding) {
        btnSave.setOnClickListener {
                addViewModel.insertMenu(fetchItems()).run {
                    findNavController().navigate(R.id.actionAddMenuCategoryFragmentToMenuManagementFragment)
                }
            }
        }

    private fun fetchItems(): FoodItem = binding.layoutMenuAddItem.let {
        val title = it.tieMenuName.text.toString()
        val price = it.tieMenuPrice.text.toString().toLong()
        val quantity = it.tieMenuQuantity.text.toString().toInt()
        val category = it.actCategory.text.toString()
        val image = it.insertPhoto.toString()

        return@fetchItems FoodItem(title,price,quantity,category,image)
    }
}
