package uz.behzoddev.restaurantpos.view.order_store

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.databinding.ItemFoodBinding
import javax.inject.Inject

class OrderStoreAdapter @Inject constructor()  : RecyclerView.Adapter<OrderStoreAdapter.OrderStoreViewHolder>() {

    inner class OrderStoreViewHolder(val binding: ItemFoodBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        private val diffCallBack = object : DiffUtil.ItemCallback<FoodItem>() {
            override fun areItemsTheSame(oldItem: FoodItem, newItem: FoodItem): Boolean {
                return oldItem.foodItemId == newItem.foodItemId
            }

            override fun areContentsTheSame(oldItem: FoodItem, newItem: FoodItem): Boolean {
                return oldItem.foodItemPhoto == newItem.foodItemPhoto
                        && oldItem.foodItemName == newItem.foodItemName
                        && oldItem.foodItemPrice == newItem.foodItemPrice
            }
        }
    }

    val diffUtil = AsyncListDiffer(this, diffCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderStoreViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderStoreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderStoreViewHolder, position: Int) {
        val foodMenuItem = diffUtil.currentList[position]
        holder.binding.apply {
            tvMenuName.text = foodMenuItem.foodItemName
            tvMenuPrice.text = foodMenuItem.foodItemPrice.toString()
        }
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(foodMenuItem) }
        }
    }

    private var onItemClickListener: ((FoodItem) -> Unit)? = null

    fun setOnClickListener(listener: (FoodItem) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int {
        return diffUtil.currentList.size
    }
}