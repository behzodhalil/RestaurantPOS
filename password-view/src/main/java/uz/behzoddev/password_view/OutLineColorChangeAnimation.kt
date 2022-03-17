package uz.behzoddev.password_view

internal class OutLineColorChangeAnimation(
    private val circleView: CircleView
) : ColorChangeAnimation(circleView) {

    override fun getColor(): Int = circleView.getOutLineColor()

    override fun setColor(color: Int) {
        circleView.setOutLineColor(color)
    }
}