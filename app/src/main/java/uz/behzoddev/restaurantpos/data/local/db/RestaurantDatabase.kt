package uz.behzoddev.restaurantpos.data.local.db

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import uz.behzoddev.restaurantpos.common.local.RoomContract
import uz.behzoddev.restaurantpos.data.local.dao.FoodItemDao
import uz.behzoddev.restaurantpos.data.local.dao.FoodMenuDao
import uz.behzoddev.restaurantpos.data.local.dao.FoodOrderDao
import uz.behzoddev.restaurantpos.data.local.dao.FoodStoreDao
import uz.behzoddev.restaurantpos.data.local.models.FoodItem
import uz.behzoddev.restaurantpos.data.local.models.FoodMenu
import uz.behzoddev.restaurantpos.data.local.models.FoodOrder
import uz.behzoddev.restaurantpos.data.local.models.FoodStore
import uz.behzoddev.restaurantpos.data.worker.RestaurantWorker

@Database(
    entities = [FoodStore::class, FoodMenu::class, FoodItem::class,FoodOrder::class],
    version = 11,
    autoMigrations = [
        AutoMigration(from = 10, to = 11)
    ],
    exportSchema = true
)
@TypeConverters(Converter::class)
abstract class RestaurantDatabase : RoomDatabase() {

    abstract fun getItemDao(): FoodItemDao
    abstract fun getMenuDao(): FoodMenuDao
    abstract fun getStoreDao(): FoodStoreDao
    abstract fun getOrderDao(): FoodOrderDao

    companion object {
        @Volatile
        private var INSTANCE: RestaurantDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            RestaurantDatabase::class.java,
            RoomContract.DATABASE_NAME
        ).addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                val request = OneTimeWorkRequestBuilder<RestaurantWorker>().build()
                WorkManager.getInstance(context).enqueue(request)
            }
        }).fallbackToDestructiveMigration().build()

    }
}

