package uz.behzoddev.restaurantpos.common.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 *
 */
abstract class BaseViewHolder <out T: ViewBinding>(VB: T) : RecyclerView.ViewHolder(VB.root) {
    abstract fun <T> bind(item: T)
}