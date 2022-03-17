package uz.behzoddev.password_view

import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.view.View

internal class ShakeAnimator(
    private val target: View
) : Animator(target) {

    private var animator = ValueAnimator.ofFloat(0f, 1f)
    var duration: Long = 400
    var startDelay: Long = 0
    var shakeMaxWidth: Int = 40
    var shakeTimes: Int = 4

    override fun start() {
        animator.run {
            cancel()
            duration = this@ShakeAnimator.duration
            startDelay = this@ShakeAnimator.startDelay

            val initialPositionX = target.x
            addUpdateListener {
                val progress = it.animatedValue as Float
                target.run {
                    x = initialPositionX + kotlin.math.sin(shakeTimes * Math.PI * progress).toFloat() * shakeMaxWidth / 2
                }
            }
            start()
        }
    }

    override fun addListener(listener: AnimatorListener) {
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: android.animation.Animator?) {
                listener.onAnimationEnd()
            }
        })
    }

    override fun removeAllListener() {
        animator.removeAllListeners()
    }
}