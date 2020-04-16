package com.dao.practicedraw.widget

import android.content.Context
import android.graphics.*
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View
import com.dao.practicedraw.utils.dip2Px

/**
 * 画个圆形
 * @author daoz
 * @date :2020/3/30 14:09
 */
class SportsView : View {
    // 初始化Paint对象
    var paint: Paint = Paint()
    var radius = dip2Px(80f)
    private var progress = 0f
    private var arcRectF = RectF()
    private val bounds = Rect()

    // 创建 getter 方法
    fun getProgress(): Float {
        return progress
    }

    // 创建 setter 方法
    fun setProgress(progress: Float) {
        this.progress = progress
        invalidate()
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 颜色
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = dip2Px(15f)
        paint.isAntiAlias = true
        paint.strokeCap = Paint.Cap.ROUND
        paint.textSize = dip2Px(20f)

        val centerX = (width / 2).toFloat()
        val centerY = (height / 2).toFloat()
        // 画一个弧形或扇形
        // drawArc() 是使用一个椭圆来描述弧形的。left, top, right, bottom 描述的是这个弧形所在的椭圆；
        // startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度），
        // sweepAngle 是弧形划过的角度；useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形。

        arcRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius)

        canvas?.drawArc(arcRectF, 135f, progress * 2.7f, false, paint)

        paint.color = Color.BLACK

        paint.style = Paint.Style.FILL

        val text = "${progress.toInt()}%"
        paint.getTextBounds(text, 0, text.length, bounds)

        canvas?.drawText(text, centerX - bounds.right / 2, centerY - (paint.ascent() + paint.descent()) / 2, paint)

    }
}

