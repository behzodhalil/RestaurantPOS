package uz.behzoddev.restaurantpos.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.common.states.DetailState
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.databinding.FragmentItemDetailBinding
import uz.behzoddev.restaurantpos.presentation.menu.DetailMenuViewModel

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentItemDetailBinding>() {

    private val args: DetailFragmentArgs by navArgs()
    private val detailViewModel: DetailMenuViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentItemDetailBinding {
        return FragmentItemDetailBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchById(args.foodItem.foodItemId)
        observeDetail()
        onNavigationMenuManagement()
    }

    private fun fetchById(id: Long) {
        detailViewModel.fetchById(id)
    }

    private fun onNavigationMenuManagement() {
        binding.btnBack.setOnClickListener {
            val actionDetailToMenu = DetailFragmentDirections.actionDetailFragmentToMenuManagementFragment()
            findNavController().navigate(actionDetailToMenu)
        }
    }
    private fun observeDetail() = lifecycleScope.launchWhenCreated {
        detailViewModel.detailState.collect { result ->
            when(result) {
                is DetailState.Loading -> {}
                is DetailState.Empty -> {}
                is DetailState.Success -> {
                    onDetailSaved(result.data)
                }
                is DetailState.Failure -> {}
            }

        }
    }
    private fun onDetailSaved(foodItem: FoodItem) = with(binding.layoutDetailItem) {
        tvDetailTitle.text = foodItem.foodItemName
        tvDetailTitleEng.text = foodItem.foodItemNameEnglish
        tvDetailDescription.text = foodItem.foodItemDescription
        tvServingSize.text = foodItem.foodServingSize.toString()
        tvDetailSodium.text = foodItem.foodSodium.toString()
        tvDetailSaturatedFat.text = foodItem.foodSaturatedFat.toString()
        tvDetailProtein.text = foodItem.foodProtein.toString()
        tvDetailSugar.text = foodItem.foodSugar.toString()
        tvDetailCaffeine.text = foodItem.foodCaffeine.toString()
        tvDetailAllergen.text = foodItem.foodAllergens.toString()
    }
}