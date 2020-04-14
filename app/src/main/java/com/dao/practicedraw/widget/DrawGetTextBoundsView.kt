package com.dao.practicedraw.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * 画个圆形
 * @author daoz
 * @date :2020/3/30 14:09
 */
class DrawGetTextBoundsView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    // 初始化Paint对象
    var paint: Paint = Paint()

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 颜色
        paint.color = Color.BLACK
        // 风格
        // FILL 是填充模式
        // STROKE 是画线模式（即勾边模式）
        // FILL_AND_STROKE 是两种模式一并使用：既画线又填充。它的默认值是 FILL，填充模式。
        paint.style = Paint.Style.FILL
        // 在 STROKE 和 FILL_AND_STROKE 下，还可以使用 paint.setStrokeWidth(float width) 来设置线条的宽度
        paint.strokeWidth = 2f
        // 抗锯齿 其他写法 Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.isAntiAlias = true
        paint.textSize = 40f

        val bounds = Rect()
        val text = "PengDaoZhan"
        val offsetX = 100
        val offsetY = 100
        canvas?.drawText(text, offsetX.toFloat(), offsetY.toFloat(), paint)

        paint.getTextBounds(text, 0, text.length, bounds)
        bounds.left += offsetX
        bounds.top += offsetY
        bounds.right += offsetX
        bounds.bottom += offsetY
        paint.style = Paint.Style.STROKE
        canvas?.drawRect(bounds, paint)
    }
}