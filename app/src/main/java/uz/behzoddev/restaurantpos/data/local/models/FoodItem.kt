package uz.behzoddev.restaurantpos.data.local.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import uz.behzoddev.restaurantpos.common.local.RoomContract

@Parcelize
@Entity(tableName = RoomContract.FoodItemContract.FOOD_ITEM_TABLE)
data class FoodItem(
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_NAME)
    var foodItemName : String,
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_PRICE)
    var foodItemPrice : Long,
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_SUB_COUNT)
    var foodItemSubCount : Int,
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_TOTAL_COUNT)
    var foodItemTotalCount : Int,
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_CATEGORY)
    var foodItemCategory : String,
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_PHOTO)
    var foodItemPhoto : String,
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_PAID)
    var foodItemIsPaid: Boolean = false,
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_ID)
    @PrimaryKey(autoGenerate = true)
    var foodItemId : Long = 0
) : Parcelable
