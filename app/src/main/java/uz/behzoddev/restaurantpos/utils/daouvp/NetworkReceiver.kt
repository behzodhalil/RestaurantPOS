package uz.behzoddev.restaurantpos.utils.daouvp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.hardware.usb.UsbDevice
import android.net.ConnectivityManager
import android.os.Build
import android.os.Parcelable
import uz.behzoddev.restaurantpos.common.extensions.debug
import uz.behzoddev.restaurantpos.view.MainActivity


class NetworkReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        debug { "Daou Receiver -> Action Message: $action" }
        if (action == "android.net.conn.CONNECTIVITY_CHANGE") {
            try {
                val connectivityManager =
                    context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val activeNetworkInfo = connectivityManager.activeNetworkInfo
                val networkInfo = connectivityManager.getNetworkInfo(1)
                val networkInfo2 = connectivityManager.getNetworkInfo(9)
                if (networkInfo != null) {
                    if (networkInfo == null || activeNetworkInfo == null) {
                        debug { "d" }
                    } else {
                        debug { "WIFI CONNECT SUCCESS: ${networkInfo.isConnected}" }
                    }
                }
                if (networkInfo2 != null) {
                    if (networkInfo2 != null) {
                        debug { "ETHERNET CONNECT SUCCESS: ${networkInfo2.isConnected}" }
                    } else {
                        debug { "ETHERNET CONNECT FAIL" }
                    }
                }
            } catch (e: Exception) {
                debug { "${e.message}" }
            }
        }
        if (action == "android.hardware.usb.action.USB_DEVICE_ATTACHED") {
            debug { "ACTION_USB_DEVICE_ATTACHED" }
            // MainActivity.RCONN_STAT = 1
            val usbDevice = intent.getParcelableExtra<Parcelable>("device") as UsbDevice?
        } else if (action == "android.hardware.usb.action.USB_DEVICE_DETACHED") {
            debug { "ACTION_USB_DEVICE_DETACHED" }
            // MainActivity.RCONN_STAT = 0
            val usbDevice2 = intent.getParcelableExtra<Parcelable>("device") as UsbDevice?
        }
        if (action == "android.intent.action.SCREEN_ON") {
            debug { "***************SCREEN_ON***************" }
            // MainActivity.SCR_STAT = 2
        } else if (action == "android.intent.action.SCREEN_OFF") {
            debug { "***************SCREEN_OFF***************" }
            // MainActivity.SCR_STAT = 0
        }
        if (action == "android.intent.action.BOOT_COMPLETED" && MainActivity.LAUNCH_MODE !== 1) {
            if (Build.VERSION.SDK_INT >= 26) {
                val intent2 = Intent(context, MainActivity::class.java)
                intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent2)
                return
            }
            val intent3 = Intent(context, MainActivity::class.java)
            intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent3)
        }
    }
}