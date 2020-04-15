package com.dao.practicedraw.widget

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.animation.ValueAnimator.INFINITE
import android.animation.ValueAnimator.REVERSE
import android.content.Context
import android.graphics.*
import android.support.design.circularreveal.CircularRevealWidget
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.dao.practicedraw.R
import kotlinx.android.synthetic.main.activity_main.view.*

/**
 * 翻页效果
 * @author daoz
 * @date :2020/3/30 14:09
 */
class DrawTurnPageView : View {

    // 初始化Paint对象
    var paint: Paint = Paint()
    val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.batman)
    var camera = Camera()
    private var degree: Int = 0
    var animator = ObjectAnimator.ofInt(this, "degree", 0, 180)

    constructor(context: Context?) : super(context) {
        init()
    }

    private fun init() {

        animator.duration = 2500
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = INFINITE
        animator.repeatMode = REVERSE
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animator.start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator.end()
    }

    @SuppressWarnings("unused")
    fun setDegree(degree: Int) {
        this.degree = degree
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val bitmapWidth = bitmap.width
        val bitmapHeight = bitmap.height
        val centerX = width / 2
        val centerY = height / 2
        val x = centerX - bitmapWidth / 2
        val y = centerX - bitmapHeight / 2

        canvas?.save()

        camera.save()
        camera.rotateY(degree.toFloat())
        canvas?.translate(centerX.toFloat(), centerY.toFloat())
        camera.applyToCanvas(canvas)
        canvas?.translate(-centerX.toFloat(), -centerY.toFloat())
        camera.restore()

        canvas?.drawBitmap(bitmap, x.toFloat(), y.toFloat(), paint)
        canvas?.restore()

    }
}