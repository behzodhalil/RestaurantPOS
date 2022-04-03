package uz.behzoddev.restaurantpos.data.local.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class FoodOrderItem(
    val item: FoodItem,
    var quantity: Int,
): Parcelable {
    fun getAmount (): Long = item.foodItemPrice * quantity
}

