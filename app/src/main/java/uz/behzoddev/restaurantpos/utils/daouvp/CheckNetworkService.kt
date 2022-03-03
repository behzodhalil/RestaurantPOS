package uz.behzoddev.restaurantpos.utils.daouvp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.test.core.app.ApplicationProvider


class CheckNetworkService : Service() {

    private lateinit var checkNetworkConnection: CheckNetworkConnection

    override fun onBind(intent: Intent?): IBinder {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, i: Int, i2: Int): Int {
        checkNetworkConnection = CheckNetworkConnection(ApplicationProvider.getApplicationContext())
        checkNetworkConnection.register()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        checkNetworkConnection.unregister()
    }
}
