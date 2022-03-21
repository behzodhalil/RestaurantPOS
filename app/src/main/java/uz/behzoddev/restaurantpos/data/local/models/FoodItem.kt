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
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_CATEGORY)
    var foodItemCategory : String,
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_PHOTO)
    var foodItemPhoto : String,
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_SERVING_SIZE)
    var foodServingSize: Int,
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_SODIUM)
    var foodSodium: Int,
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_SATURATED_FAT)
    var foodSaturatedFat: Int,
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_SUGAR)
    var foodSugar: Int,
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_PROTEIN)
    var foodProtein: Int,
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_CAFFEINE)
    var foodCaffeine: Int,
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_ALLERGENS)
    var foodAllergens: String,
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_PAID)
    var foodItemIsPaid: Boolean = false,
    @ColumnInfo(name = RoomContract.FoodItemContract.FOOD_ITEM_ID)
    @PrimaryKey(autoGenerate = true)
    var foodItemId : Long = 0
) : Parcelable
