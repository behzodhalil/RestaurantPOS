package uz.behzoddev.restaurantpos.data.local.dao

import androidx.room.Dao

@Dao
interface FoodMenuDao {

    suspend fun insertMenu()
    suspend fun updateMenu()
    fun fetchAllMenu()

}