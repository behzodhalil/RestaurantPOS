package uz.behzoddev.restaurantpos.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.behzoddev.restaurantpos.common.local.RoomContract

@Entity(tableName = RoomContract.FoodMenuContract.FOOD_MENU_TABLE)
data class FoodMenu(
    @ColumnInfo(name = RoomContract.FoodMenuContract.FOOD_MENU_ID)
    @PrimaryKey(autoGenerate = true)
    val foodMenuId: Int,
    @ColumnInfo(name = RoomContract.FoodMenuContract.FOOD_MENU_NAME)
    var foodMenuName: String
)
