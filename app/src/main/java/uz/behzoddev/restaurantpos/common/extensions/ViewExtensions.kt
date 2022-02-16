package uz.behzoddev.restaurantpos.common.extensions

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * The Fragment toast extension functions
  */
fun Fragment.showToastLong(message: String) {
    Toast.makeText(activity,message,Toast.LENGTH_LONG).show()
}
fun Fragment.showToastShort(message : String) {
    Toast.makeText(activity,message,Toast.LENGTH_SHORT).show()
}

/**
 * The Activity toast extension functions
 */
fun AppCompatActivity.showToastLong(message: String) {
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}
fun AppCompatActivity.showToastShort(message: String) {
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}