package uz.behzoddev.password_view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.view.View
import androidx.core.animation.addListener

abstract class ColorChangeAnimation (target: View) : Animation (target)  {

    private var animator: ValueAnimator? = null
    var toColor: Int = 0
    var duration: Long = 200
    var startDelay: Long = 100

    override fun startAnimation() {
        animator = ValueAnimator.ofArgb(getColor(),toColor).apply {
            duration = this@ColorChangeAnimation.duration
            startDelay = this@ColorChangeAnimation.startDelay
            addUpdateListener {
                setColor(it.animatedValue as Int)
            }
            animator?.start()
        }
    }

    override fun addListener(listener: AnimationListener) {
        animator?.addListener(object  : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                listener.onAnimationEnd()
            }
        })
    }
    protected abstract fun getColor() : Int
    abstract fun setColor(color: Int)
}