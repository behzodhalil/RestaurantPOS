package uz.behzoddev.restaurantpos.view.payment

import android.content.Context
import android.content.SharedPreferences
import android.hardware.usb.UsbManager
import android.os.Bundle
import android.os.Handler
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class PaymentActivity : AppCompatActivity() {


    companion object {
        const val CONDITION_TYPE_INI_FILE = 3
        const val CONDITION_TYPE_INTEGRITY = 2
        const val CONDITION_TYPE_LAUNCH = 0
        const val CONDITION_TYPE_NETWORK = 1
        const val CONDITION_TYPE_SECURITY = 4
        const val CONDITION_VALUE_FAIL = 1
        const val CONDITION_VALUE_GOOD = 0
        const val DLGMSG_BASE_BOX_BALL = 3
        const val DLGMSG_BASE_BOX_BCANCEL = 2
        const val DLGMSG_BASE_BOX_BCONFIRM = 1
        const val DLGMSG_BASE_BOX_BNON = 0
        const val DLGMSG_BASE_BOX_INTENT = 4
        const val DLGMSG_BASE_BOX_INTENT_SIGN = 5
        const val DLGMSG_BASE_BOX_INTENT_SIGN_PIN = 6
        const val DLGMSG_INPUT_PW = 2000
        const val DLGMSG_INPUT_SIGN = 1000
        const val DLGMSG_RETURN_BCANCEL = 2
        const val DLGMSG_RETURN_BCONFIRM = 1
        const val DLGMSG_RETURN_NON = 0
        const val DLGMSG_RETURN_TIMEOUT = 3
       //  var DevDrv: DeviceDriver = DeviceDriver()
        const val ENABLE_OVERLAY_DRAW = 5469
        const val KEY_DATA = "KEY_DATA"
        var LAUNCH_MODE = 0
        const val MAX_DATA_LEN = 8192
        var RCONN_STAT = 2
        var SCR_STAT = 1
        var bIntergrity_status = false
        var bNetwork_status = false
        var bStatusTvSecurity = false
        var dialog_msg: String? = null
        var dialog_status = 0
        var dialog_timer: Long = 0
        var dialog_type = 0
        var iBuf_Cnt = 0
        // var mContext: Context? = null
        private val mHandler: Handler? = null
        var sharedPref: SharedPreferences? = null
        var static_UsbManager: UsbManager? = null
        var strMsg_HW: String? = null
        var strMsg_SW: String? = null
        var strPrtTransResult: String? = null
        var strPrtTransResult_apprvno: String? = null
        var strPrtTransResult_msg: String? = null
        var strPrtTransResult_total: String? = null
        var strSendReplyMsgToPOS = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}