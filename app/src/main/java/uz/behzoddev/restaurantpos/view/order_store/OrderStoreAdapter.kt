package uz.behzoddev.restaurantpos.view.order_store


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.behzoddev.restaurantpos.R
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.databinding.ItemFoodBinding



class OrderStoreAdapter
    : RecyclerView.Adapter<OrderStoreAdapter.OrderStoreViewHolder>() {


    private var listener : FoodItemListener? = null

    internal fun setOnAddClickListener (foodItemListener: FoodItemListener) {
        this.listener = foodItemListener
    }

    interface OrderStoreListener {
        fun onClickDetail(listener: FoodItem)
    }
    private var orderCallBackListener: OrderStoreListener? = null

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
            Glide.with(ivMenu.context)
                .load(foodMenuItem.foodItemPhoto)
                .placeholder(R.drawable.iv_nitro)
                .fitCenter()
                .into(ivMenu)
        }
        holder.itemView.setOnClickListener {

        }
        holder.binding.ivDetail.setOnClickListener {
            onDetailItemClickListener?.let {
                it(foodMenuItem)
        }
        holder.binding.ivDetail.setOnClickListener {

        }
        }

    }

    private var onItemClickListener: ((FoodItem) -> Unit)? = null

    fun setOnClickListener(listener: (FoodItem) -> Unit) {
        onItemClickListener = listener
    }

    fun setOnClick2Listener(listener: OrderStoreListener) {
        this.orderCallBackListener = listener
    }

    fun setOnClickAddListener(listener : (FoodItem) -> Unit) {
        onItemClickListener = listener
    }




    private var onDetailItemClickListener: ((FoodItem) -> Unit)? = null

    fun setDetailClickListener(listener: (FoodItem) -> Unit) {
        onDetailItemClickListener = listener
    }

    override fun getItemCount(): Int {
        return diffUtil.currentList.size
    }

    interface FoodItemListener {
        fun addToMenu(foodItem: FoodItem)
    }

}




