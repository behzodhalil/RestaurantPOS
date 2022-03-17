package uz.behzoddev.password_view

internal class FillAndStrokeColorChangeAnimation(
    private val circleView: CircleView
) : ColorChangeAnimation(circleView) {

    override fun getColor(): Int = circleView.getFillAndStrokeCircleColor()

    override fun setColor(color: Int) {
        circleView.setFillAndStrokeCircleColor(color)
    }
}