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
import uz.behzoddev.restaurantpos.R
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.common.states.DetailState
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.databinding.FragmentItemDetailConfirmBinding
import uz.behzoddev.restaurantpos.presentation.menu.DetailMenuViewModel

@AndroidEntryPoint
class DetailConfirmFragment : BaseFragment<FragmentItemDetailConfirmBinding>() {

    private val args: DetailConfirmFragmentArgs by navArgs()
    private val detailConfirmViewModel: DetailMenuViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentItemDetailConfirmBinding {
        return FragmentItemDetailConfirmBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchById(args.foodItem.foodItemId)
        observeDetail()
        onNavigationToMenu()
    }

    private fun fetchById(id: Long) {
        detailConfirmViewModel.fetchById(id)
    }

    private fun onNavigationToMenu() = with(binding) {
        btnConfirm.setOnClickListener {
            findNavController().navigate(R.id.actionDetailConfirmToMenu)
        }
    }
    private fun observeDetail() = lifecycleScope.launchWhenCreated {
        detailConfirmViewModel.detailState.collect { result ->
            when (result) {
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
        tvDetailAllergen.text = foodItem.foodAllergens
    }

}