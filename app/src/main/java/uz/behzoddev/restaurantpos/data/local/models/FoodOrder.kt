package uz.behzoddev.restaurantpos.data.local.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import uz.behzoddev.restaurantpos.common.local.RoomContract
import java.util.*
import kotlin.collections.ArrayList

@Parcelize
@Entity(tableName = RoomContract.FoodOrderContract.FOOD_ORDER_TABLE)
data class FoodOrder (
        @Embedded
        var orderItems: FoodItem,
        @ColumnInfo(name = RoomContract.FoodOrderContract.FOOD_ORDER_TOTAL_AMOUNT)
        var orderTotalAmount: Float,
        @ColumnInfo(name = RoomContract.FoodOrderContract.FOOD_ORDER_TOTAL_QUANTITY)
        var orderTotalQuantity: Int,
        @ColumnInfo(name = RoomContract.FoodOrderContract.FOOD_ORDER_QUANTITY)
        var orderQuantity: Int,
        @ColumnInfo(name = RoomContract.FoodOrderContract.FOOD_ORDER_NUMBER)
        var orderNumber: Int,
        @ColumnInfo(name = RoomContract.FoodOrderContract.FOOD_ORDER_IS_TAKEOUT)
        var isTakeOut: Boolean,
        @ColumnInfo(name = RoomContract.FoodOrderContract.FOOD_ORDER_IS_PAID)
        var isPaid: Boolean,
        @ColumnInfo(name = RoomContract.FoodOrderContract.FOOD_ORDER_TAX_RATED)
        var orderTaxRated: Float,
        @ColumnInfo(name = RoomContract.FoodOrderContract.FOOD_ORDER_TIME_CREATED)
        var timeCreated: Calendar = Calendar.getInstance(),
        @ColumnInfo(name = RoomContract.FoodOrderContract.FOOD_ORDER_CUSTOMER)
        var customer: String,
        @ColumnInfo(name = RoomContract.FoodOrderContract.FOOD_ORDER_IS_VALID)
        var isValid: Boolean,
        @ColumnInfo(name = RoomContract.FoodOrderContract.FOOD_ORDER_IS_STORE)
        var isStore: Boolean,
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = RoomContract.FoodOrderContract.FOOD_ORDER_ID)
        var orderId: Long
): Parcelable {

}