package uz.behzoddev.restaurantpos.view.menu_management

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import uz.behzoddev.restaurantpos.databinding.ItemExpandMenuContentBinding

class MenuManagementAdapter {

    sealed class MenuViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

        class ItemContentViewHolder(binding: ItemExpandMenuContentBinding) : MenuViewHolder(binding) {

        }
    }
}