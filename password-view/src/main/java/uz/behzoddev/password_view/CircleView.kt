package uz.behzoddev.password_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.view.View

internal class CircleView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttribute: Int = 0
) : View(context,attributeSet,defStyleAttribute) {

    private val outLinePaint = Paint(ANTI_ALIAS_FLAG).apply {
        color = resources.getColor(R.color.dodger_blue)
        strokeWidth = 3f
        style = Paint.Style.STROKE
    }

    private val fillCirclePaint = Paint(ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        style = Paint.Style.FILL
    }

    private val fillAndStrokeCirclePaint = Paint(ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        style = Paint.Style.FILL_AND_STROKE
    }
    private var radius = 56f

    private var progress = 0.0f
    set(value) {
        field = value
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = ((radius * 2) + (outLinePaint.strokeWidth)).toInt()
        val height = ((radius * 2) + (outLinePaint.strokeWidth)).toInt()
        setMeasuredDimension(width,height)
    }

    override fun onDraw(canvas: Canvas?) {

        val halfOutLineStrokeWidth = outLinePaint.strokeWidth / 2

        canvas?.drawCircle(
            radius + halfOutLineStrokeWidth,
            radius + halfOutLineStrokeWidth,
            lerp(radius - halfOutLineStrokeWidth,0f,progress),
            fillCirclePaint
        )

        canvas?.drawCircle(
            radius + halfOutLineStrokeWidth,
            radius + halfOutLineStrokeWidth,
            lerp(radius, 0f, progress),
            outLinePaint
        )

        // fill and stroke circle
        canvas?.drawCircle(
            radius + halfOutLineStrokeWidth,
            radius + halfOutLineStrokeWidth,
            lerp(0f, radius + halfOutLineStrokeWidth, progress),
            fillAndStrokeCirclePaint
        )
    }
    /*
     * Linearly interpolate between two values.
     */
    private fun lerp(a: Float, b: Float, t: Float): Float {
        return a + (b - a) * t
    }
    }
