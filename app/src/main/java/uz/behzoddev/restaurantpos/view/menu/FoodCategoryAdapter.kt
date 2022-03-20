package uz.behzoddev.restaurantpos.view.menu

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.behzoddev.restaurantpos.data.local.models.FoodCategory
import uz.behzoddev.restaurantpos.databinding.ItemCategoryBinding

class FoodCategoryAdapter(
    private val category: MutableList<FoodCategory>
) : RecyclerView.Adapter<FoodCategoryAdapter.FoodCategoryViewHolder>() {

    private var selectedItem: Int = -1

    inner class FoodCategoryViewHolder(val binding: ItemCategoryBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodCategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FoodCategoryViewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: FoodCategoryViewHolder, position: Int) {
        holder.binding.apply {
            itemCategoryTitle.text = category[position].title

            holder.itemView.setOnClickListener {
                onItemClickListener?.let {
                    it(category[position])

                    if (selectedItem == position) {
                        notifyItemChanged(position)
                        return@setOnClickListener
                    }

                    selectedItem = position
                    notifyDataSetChanged()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return category.size
    }

    private var onItemClickListener : ((FoodCategory) -> Unit)? = null
    fun setOnItemClickListener(listener: (FoodCategory) -> Unit) {
        onItemClickListener = listener
    }
}