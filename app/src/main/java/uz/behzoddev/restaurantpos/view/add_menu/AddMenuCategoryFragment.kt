package uz.behzoddev.restaurantpos.view.add_menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.behzoddev.restaurantpos.R
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.databinding.FragmentAddItemBinding
import uz.behzoddev.restaurantpos.presentation.menu.AddMenuViewModel
import uz.behzoddev.restaurantpos.utils.CoffeeCategory

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
        initCategory()
    }

    private fun insertMenu() = with(binding) {
        btnSave.setOnClickListener {
                addViewModel.insertMenu(fetchItems()).run {
                    findNavController().navigate(R.id.actionAddMenuCategoryFragmentToMenuManagementFragment)
                }
            }
        }

    private fun initCategory() {
        val coffeeCategory = ArrayAdapter(
            requireContext(),
            R.layout.layout_autocomplete,
            CoffeeCategory.coffeeCategory
        )
        with(binding) {
            layoutMenuAddItem.actCategory.setAdapter(coffeeCategory)
        }
    }
    private fun fetchItems(): FoodItem = binding.layoutMenuAddItem.let {
        val title = it.tieMenuName.text.toString()
        val titleEng = it.tieMenuNameEnglish.text.toString()
        val description = it.tieMenuDescription.text.toString()
        val price = it.tieMenuPrice.text.toString().toLong()
        val quantity = it.tieMenuQuantity.text.toString().toInt()
        val category = it.actCategory.text.toString()
        val image = it.tieMenuPhoto.text.toString()
        val servingSize = it.tieMenuServingSize.text.toString().toInt()
        val sodium = it.tieMenuSodium.text.toString().toInt()
        val saturatedFat = it.tieMenuSaturatedFat.text.toString().toInt()
        val sugar = it.tieMenuSugar.text.toString().toInt()
        val protein = it.tieMenuProtein.text.toString().toInt()
        val caffeine = it.tieMenuCaffeine.text.toString().toInt()
        val allergens = it.tieMenuAllergens.text.toString()

        return@fetchItems FoodItem(title,titleEng,description,price,quantity,category,image,servingSize,sodium,saturatedFat,sugar,protein,caffeine,allergens)
    }
}
