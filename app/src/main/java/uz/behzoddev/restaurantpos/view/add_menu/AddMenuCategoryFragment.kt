package uz.behzoddev.restaurantpos.view.add_menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.behzoddev.restaurantpos.common.base.BaseFragment
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

            }
        }
    }
