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
    var text = "药实在"
    // 移动的距离
    var movingDistance = dip2Px(0f)

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        textPaint.color = Color.parseColor("#9B9B9B")
        textPaint.isAntiAlias = true
        textPaint.textSize = dip2Px(45f)
        textPaint.typeface = Typeface.createFromAsset(context.assets, "fonts/select-title-black.ttf");
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        textPaint.getTextBounds(text, 0, text.length, bounds)
        canvas?.translate(movingDistance, dip2Px(0f))
        path.reset()
        path.rLineTo(dip2Px(15f), dip2Px(0f))
        path.lineTo(dip2Px(25f) + movingDistance / 20, (bounds.bottom - bounds.top).toFloat())
        path.rLineTo(-dip2Px(15f), dip2Px(0f))
        path.close()
        canvas?.clipPath(path)
        canvas?.drawText(text, -movingDistance, (bounds.bottom - bounds.top).toFloat(), textPaint)
    }

    fun startAnimation() {
        val annotation = ObjectAnimator.ofFloat(dip2Px(0f), (bounds.right - bounds.left).toFloat())
        annotation.duration = 1500
        annotation.repeatCount = ValueAnimator.INFINITE
        annotation.addUpdateListener {
            movingDistance = it.animatedValue as Float
            invalidate()
        }
        annotation.start()
    }

}