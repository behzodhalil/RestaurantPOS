package uz.behzoddev.restaurantpos.view.order

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder
import uz.behzoddev.restaurantpos.databinding.ItemOrderBinding
import javax.inject.Inject

class OrderAdapter @Inject constructor() : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    companion object {
        private val DiffCallBack = object : DiffUtil.ItemCallback<FoodOrder>() {
            override fun areItemsTheSame(oldItem: FoodOrder, newItem: FoodOrder): Boolean {
                return oldItem.orderId == newItem.orderId
            }

            override fun areContentsTheSame(oldItem: FoodOrder, newItem: FoodOrder): Boolean {
                return oldItem.orderItems.foodItemName == newItem.orderItems.foodItemName
                        && oldItem.orderItems.foodItemSubCount == newItem.orderItems.foodItemSubCount
                        && oldItem.orderItems.foodItemPrice == newItem.orderItems.foodItemPrice
            }
        }
    }

    val differ = AsyncListDiffer(this, DiffCallBack)

    inner class OrderViewHolder(val binding: ItemOrderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding = ItemOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val foodOrder = differ.currentList[position]
        holder.binding.apply {
            tvOrderName.text = foodOrder.orderItems.foodItemName
            tvOrderPrice.text = foodOrder.orderItems.foodItemPrice.toString()
            tvOrderQuantity.text = foodOrder.orderItems.foodItemSubCount.toString()
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}