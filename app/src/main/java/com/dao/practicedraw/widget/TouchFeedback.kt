package com.dao.practicedraw.widget

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.dao.practicedraw.utils.dip2Px

/**
 *
 * @author daoz
 * @date :2020/4/20 9:36
 */
class TouchFeedback : View {
    var paint = Paint()
    private var circleX = (width / 2).toFloat()
    private var circleY = (height / 2).toFloat()
    private var radius = dip2Px(50f)

    init {
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
        paint.color = Color.RED

        circleX = (width / 2).toFloat()
        circleY = (height / 2).toFloat()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(circleX, circleY, radius, paint)

        for (i in 1..10) {
            val moveCircleX = circleX

            val animator = ObjectAnimator.ofFloat(moveCircleX, moveCircleX + dip2Px(250f))
            animator.addUpdateListener {
                canvas?.drawCircle(it.animatedValue as Float, it.animatedValue as Float, radius, paint)
            }
            animator.start()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.actionMasked) {
            // 按下
            MotionEvent.ACTION_DOWN -> {
                circleX = event.x
                circleY = event.y
                val animator = ObjectAnimator.ofFloat(radius, dip2Px(100f))
                animator.addUpdateListener {
                    radius = it.animatedValue as Float
                    invalidate()
                }
                animator.start()


            }
            // 弹起
            MotionEvent.ACTION_UP -> {
                val animator = ObjectAnimator.ofFloat(radius, dip2Px(50f))
                animator.addUpdateListener {
                    radius = it.animatedValue as Float
                    invalidate()
                }
                animator.start()
            }
            // 移动
            MotionEvent.ACTION_MOVE -> {
                circleX = event.x
                circleY = event.y
                invalidate()
            }
            else -> {
            }
        }
        return true
    }
}