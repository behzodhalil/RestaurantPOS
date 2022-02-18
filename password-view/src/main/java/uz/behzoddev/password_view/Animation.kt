package uz.behzoddev.password_view

import android.view.View
import java.lang.RuntimeException

abstract class Animation (private val target: View) {

    abstract fun startAnimation()

    open fun addListener(listener: AnimationListener) {
        throw RuntimeException("Stub!")
    }

    open fun removeAllListener() {
        throw RuntimeException("Stub!")
    }
    interface AnimationListener {
        fun onAnimationEnd()
    }
}