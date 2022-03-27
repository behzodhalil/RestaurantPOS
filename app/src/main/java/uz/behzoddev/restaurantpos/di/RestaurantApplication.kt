package uz.behzoddev.restaurantpos.di

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import uz.behzoddev.restaurantpos.common.extensions.debug
import uz.behzoddev.restaurantpos.data.worker.RestaurantWorker
import javax.inject.Inject

@HiltAndroidApp
class RestaurantApplication : Application(),Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun onCreate() {
        super.onCreate()
        // prePopulateDataWithWorkManager()
        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(true)
            .methodCount(1)
            .methodOffset(5)
            .tag("")
            .build()

        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))

        Timber.plant(object : Timber.DebugTree() {
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                Logger.log(priority,"-$tag",message,t)
            }
        })

        debug { "onCreate() method is created" }
    }

    private fun prePopulateDataWithWorkManager() {
        val foodItemWork = OneTimeWorkRequestBuilder<RestaurantWorker>().build()
        WorkManager.getInstance(applicationContext).beginWith(foodItemWork).enqueue()
    }
    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder().setWorkerFactory(workerFactory).build()
    }
}