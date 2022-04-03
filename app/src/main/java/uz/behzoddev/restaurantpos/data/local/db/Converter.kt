package uz.behzoddev.restaurantpos.data.local.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder
import uz.behzoddev.restaurantpos.data.local.models.FoodOrderItem
import java.util.*
import javax.inject.Inject

class Converter {

    @Inject
    lateinit var gson: Gson

    @TypeConverter
    fun fromCalendarToLong(calendar: Calendar): Long {
        return calendar.timeInMillis
    }
    @TypeConverter
    fun fromLongToCalendar(value: Long): Calendar {
        return Calendar.getInstance().apply { timeInMillis = value }
    }

    @TypeConverter
    fun fromOrderItemsArrayListToString(foodOrderItems: ArrayList<FoodOrder>): String {
        return gson.toJson(foodOrderItems)
    }
    @TypeConverter
    fun fromStringToOrderItemsArrayList(string: String): ArrayList<FoodOrder> {
        return gson.fromJson(string, object : TypeToken<ArrayList<FoodOrder>>() {}.type)
    }

}