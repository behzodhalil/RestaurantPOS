package uz.behzoddev.restaurantpos.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber
import uz.behzoddev.restaurantpos.R
import uz.behzoddev.restaurantpos.common.extensions.debug

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        debug { "onCreate() : Inside MainActivity!" }
    }
}