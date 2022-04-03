package uz.behzoddev.restaurantpos.view.order

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.behzoddev.restaurantpos.data.local.models.FoodOrderItem
import uz.behzoddev.restaurantpos.databinding.ItemOrderBinding

class OrderItemAdapter : ListAdapter<FoodOrderItem,RecyclerView.ViewHolder>(OrderItemDiffCallBack()) {

    inner class OrderItemViewHolder(val binding: ItemOrderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FoodOrderItem, position: Int) {
            binding.apply {
                tvOrderName.text = item.item.foodItemName
                tvOrderQuantity.text = item.quantity.toString()
                tvOrderPrice.text = item.item.foodItemPrice.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemOrderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return OrderItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val foodOrderItem = getItem(position)
        (holder as OrderItemViewHolder).bind(foodOrderItem,position)
    }

    private class OrderItemDiffCallBack : DiffUtil.ItemCallback<FoodOrderItem>() {
        override fun areItemsTheSame(oldItem: FoodOrderItem, newItem: FoodOrderItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: FoodOrderItem, newItem: FoodOrderItem): Boolean {
            return oldItem == newItem
        }
    }
}