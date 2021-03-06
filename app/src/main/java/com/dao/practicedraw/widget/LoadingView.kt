package com.dao.practicedraw.widget

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.dao.practicedraw.R
import com.dao.practicedraw.utils.dip2Px
import org.w3c.dom.Text

/**
 *
 * @author daoz
 * @date :2020/4/24 13:43
 */
class LoadingView : View {
    private val textPaint = TextPaint()
    private val path = Path()
    private val bounds = Rect()
    private var text: String = "文字动画"
    private var textSize = dip2Px(45f)
    private var textColor = "#9B9B9B"
    // 线条宽度
    private var lineWidth = dip2Px(15f)
    // 偏移距离
    private var offsetDistance = dip2Px(25f)
    // 动画时间
    private var animationTime = 1500
    // 移动的距离
    private var movingDistance = dip2Px(0f)

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        textPaint.color = Color.parseColor(textColor)
        textPaint.isAntiAlias = true
        textPaint.textSize = textSize
        textPaint.typeface = Typeface.createFromAsset(context.assets, "fonts/select-title-black.ttf");
        textPaint.getTextBounds(text, 0, text.length, bounds)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.translate(movingDistance - offsetDistance, dip2Px(0f))
        path.reset()
        path.rLineTo(lineWidth, dip2Px(0f))
        path.lineTo(offsetDistance, (bounds.bottom - bounds.top).toFloat())
        path.rLineTo(-lineWidth, dip2Px(0f))
        path.close()
        canvas?.clipPath(path)
        canvas?.drawText(text, -movingDistance + offsetDistance, (bounds.bottom - bounds.top).toFloat(), textPaint)
    }

    fun startAnimation() {
        val annotation = ObjectAnimator.ofFloat(dip2Px(0f),
            bounds.right - bounds.left + offsetDistance)
        annotation.duration = animationTime.toLong()
        annotation.repeatCount = ValueAnimator.INFINITE
        annotation.addUpdateListener {
            movingDistance = it.animatedValue as Float
            invalidate()
        }
        annotation.start()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(bounds.right - bounds.left, bounds.bottom - bounds.top)
    }

    /**
     * 设置文字
     */
    fun setLoadingText(text: String) {
        this.text = text
        textPaint.getTextBounds(text, 0, text.length, bounds)
        invalidate()
    }

    /**
     * 设置文字大小
     */
    fun setLoadingTextSize(textSize: Float) {
        this.textSize = textSize
        textPaint.textSize = textSize
        invalidate()
    }

    /**
     * 设置线条文字移动颜色
     */
    fun setLoadingTextColor(textColor: String) {
        this.textColor = textColor
        textPaint.color = Color.parseColor(textColor)
        invalidate()
    }

    /**
     * 设置动画时间
     */
    fun setLoadingAnimationTime(animationTime: Int) {
        this.animationTime = animationTime
        invalidate()
    }

    /**
     * 设置移动线条宽度
     */
    fun setLineWidth(lineWidth: Float) {
        this.lineWidth = lineWidth
        invalidate()
    }

    /**
     * 移动线条偏移距离
     */
    fun setOffsetDistance(offsetDistance: Float) {
        this.offsetDistance = offsetDistance
        invalidate()
    }

}