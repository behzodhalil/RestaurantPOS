package uz.behzoddev.password_view

import android.view.View

abstract class Animator(private val target: View) {

    abstract fun start()

    open fun addListener(listener: AnimatorListener) {
        throw RuntimeException("Stub!")
    }

    open fun removeAllListener() {
        throw RuntimeException("Stub!")
    }

    interface AnimatorListener {
        fun onAnimationEnd()
    }
}