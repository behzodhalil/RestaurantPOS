package uz.behzoddev.restaurantpos.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.behzoddev.restaurantpos.data.local.dao.FoodItemDao
import uz.behzoddev.restaurantpos.data.local.dao.FoodMenuDao
import uz.behzoddev.restaurantpos.data.local.dao.FoodStoreDao
import uz.behzoddev.restaurantpos.data.local.db.RestaurantDatabase
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabaseInstance(application: Application) : RestaurantDatabase {
        return RestaurantDatabase.invoke(application)
    }
    @Provides
    @Singleton
    fun provideItemDaoInstance(database: RestaurantDatabase) : FoodItemDao {
        return database.getItemDao()
    }
    @Provides
    @Singleton
    fun provideMenuDaoInstance(database: RestaurantDatabase) : FoodMenuDao {
        return database.getMenuDao()
    }
    @Provides
    @Singleton
    fun provideStoreDaoInstance(database: RestaurantDatabase) : FoodStoreDao{
        return database.getStoreDao()
    }
}