package uz.behzoddev.password_view

import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import androidx.interpolator.view.animation.FastOutSlowInInterpolator

internal class SpringAnimator(
    private val target: View
) : Animator(target) {

    private val animatorSet = AnimatorSet()

    var duration: Long = 150
    var startDelay: Long = 0

    var moveTopY: Float = target.y - 30f
        set(value) {
            field = target.y - value
        }

    var moveBottomY: Float = target.y + 10f
        set(value) {
            field = target.y + value
        }

    override fun start() {
        animatorSet.run {
            val initialPositionY = target.y
            val animator1 = ObjectAnimator.ofFloat(target, "y", moveTopY)
            val animator2 = ObjectAnimator.ofFloat(target, "y", moveBottomY)
            val animator3 = ObjectAnimator.ofFloat(target, "y", initialPositionY)
            playSequentially(animator1, animator2, animator3)

            interpolator = FastOutSlowInInterpolator()
            duration = this@SpringAnimator.duration
            startDelay = this@SpringAnimator.startDelay

            start()
        }
    }

    override fun addListener(listener: AnimatorListener) {
        animatorSet.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: android.animation.Animator?) {
                listener.onAnimationEnd()
            }
        })
    }
}