package uz.behzoddev.restaurantpos.data.local.models

import androidx.room.Entity

@Entity(tableName = "food_password_table")
data class FoodPassword(
    var foodPasswordId: Long = 0,
    var foodPassword : Int
)