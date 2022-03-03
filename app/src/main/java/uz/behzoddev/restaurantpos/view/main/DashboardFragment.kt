package uz.behzoddev.restaurantpos.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.behzoddev.restaurantpos.R
import uz.behzoddev.restaurantpos.common.base.BaseFragment
import uz.behzoddev.restaurantpos.databinding.FragmentDashboardBinding

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private lateinit var languageSpinner: Spinner

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onNavigationToSettings()
        onNavigateToStore()
        onNavigateToTakeOut()
    }

    private fun onNavigationToSettings() = with(binding) {
        var clickCounter = 0
        rootLayout.setOnClickListener {
            clickCounter +=1
            if(clickCounter == 5) {
                clickCounter = 0
                findNavController().navigate(R.id.actionMainFragmentToMenuSettingsFragment)
            }
        }
    }

    private fun onNavigateToStore() = with(binding) {
        btnOrderStore.setOnClickListener {
            findNavController().navigate(R.id.actionMainFragmentToOrderStoreFragment)
        }
    }

    private fun onNavigateToTakeOut() = with(binding) {
        btnOrderTakeOut.setOnClickListener {
            findNavController().navigate(R.id.actionMainFragmentToOrderTakeOutFragment)
        }
    }
}