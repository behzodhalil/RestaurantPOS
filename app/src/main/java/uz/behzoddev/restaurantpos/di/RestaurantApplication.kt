package uz.behzoddev.restaurantpos.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RestaurantApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}