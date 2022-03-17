package uz.behzoddev.restaurantpos.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import uz.behzoddev.restaurantpos.R
import uz.behzoddev.restaurantpos.common.extensions.debug
import uz.behzoddev.restaurantpos.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var decorView: View

    companion object {
        const val LAUNCH_MODE = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideSystemUI()
        debug { "onCreate() method is created" }
        setupNavigation()
    }

    private fun hideSystemUI() {
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        decorView = window.decorView
        val uiOptions = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        decorView.systemUiVisibility = uiOptions
    // https://developer.android.com/training/system-ui/navigation.htm
    // https://stackoverflow.com/questions/52379561/how-android-bottom-navigation-bar-hide-permanently-or-disable
    }

    private fun setupNavigation() {
        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
            ?: return
        debug { "setupNavigation() method is created" }
    }
}

// https://androidwave.com/android-check-internet-connection/
// https://androidwave.com/mastering-in-android-service/
// https://androidwave.com/upload-files-to-server-using-service-in-android/
// https://androidwave.com/passing-data-between-fragments/
// https://androidwave.com/workmanager-constraints/
// https://androidwave.com/pagination-in-recyclerview/
// https://androidwave.com/android-recyclerview-example-best-practices/
// https://iamnaran.medium.com/viewpager2-with-tablayout-android-310bc7360cb5
// https://medium.com/1mgofficial/how-recyclerview-works-internally-71290de5d2c4
// https://medium.com/android-news/keddit-part-4-recyclerview-delegate-adapters-data-classes-with-kotlin-9248f44327f7
// https://medium.com/mindorks/diffutils-improving-performance-of-recyclerview-102b254a9e4a
// https://info-anikdey003.medium.com/working-with-viewpager2-c4a43227486b
// https://hanru-yeh.medium.com/fix-viewpager2-s-memory-leak-by-lifecycle-aware-component-786d3a3f97c2
// https://hardik-bambhania.medium.com/kotlin-flow-basic-b80cf491f16
// https://medium.com/mindorks/mastering-design-patterns-in-android-with-kotlin-a6d83b24c363