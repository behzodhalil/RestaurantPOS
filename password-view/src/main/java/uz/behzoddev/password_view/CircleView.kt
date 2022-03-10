package uz.behzoddev.password_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable
import kotlin.math.min

// https://github.com/hanks-zyh/PasscodeView/blob/master/passcodeview/src/main/res/layout/layout_passcode_view.xml
internal class CircleView : View {
    private var mPaint: Paint? = null
    private var color = Color.BLACK

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, @Nullable attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        mPaint = Paint(ANTI_ALIAS_FLAG)
    }

    fun setColor(color: Int) {
        this.color = color
        invalidate()
    }

    fun getColor(): Int {
        return color
    }

    override fun onDraw(canvas: Canvas) {
        val width = (width - paddingLeft - paddingRight) * 0.5
        val height = (height - paddingTop - paddingBottom) * 0.5
        val cx = (paddingLeft + width).toInt()
        val cy = (paddingTop + height).toInt()
        val radius = min(width, height).toInt()
        mPaint!!.color = color
        canvas.drawCircle(cx.toFloat(), cy.toFloat(), radius.toFloat(), mPaint!!)
    }
}