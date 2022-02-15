package uz.behzoddev.restaurantpos.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.behzoddev.restaurantpos.common.local.RoomContract

@Entity(tableName = RoomContract.FoodStore.FOOD_STORE_TABLE)
data class FoodStore(
    @ColumnInfo(name = RoomContract.FoodStore.FOOD_STORE_BRANCH_NAME)
    var foodStoreBranchName : String,
    @ColumnInfo(name = RoomContract.FoodStore.FOOD_STORE_OWNER_NAME)
    var foodStoreOwnerName : String,
    @ColumnInfo(name = RoomContract.FoodStore.FOOD_STORE_PHONE_NUMBER)
    var foodStorePhoneNumber : Int,
    @ColumnInfo(name = RoomContract.FoodStore.FOOD_STORE_ADDRESS)
    var foodStoreAddress: String,
    @ColumnInfo(name = RoomContract.FoodStore.FOOD_STORE_ID)
    @PrimaryKey(autoGenerate = false)
    var foodStoreId: Long = 0
)
