package uz.behzoddev.restaurantpos.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import uz.behzoddev.restaurantpos.common.local.RoomContract

@Entity(tableName = RoomContract.FoodMenu.FOOD_MENU_TABLE)
data class FoodMenu(
    @ColumnInfo(name = RoomContract.FoodMenu.FOOD_MENU_ID)
    val foodMenuId: Int,
    @ColumnInfo(name = RoomContract.FoodMenu.FOOD_MENU_NAME)
    var foodMenuName: String
)
