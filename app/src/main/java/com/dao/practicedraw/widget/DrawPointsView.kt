package com.dao.practicedraw.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * 画个点
 * @author daoz
 * @date :2020/3/30 14:09
 */
class DrawPointsView : View{
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

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 颜色
        paint.color = Color.RED
        // 风格
        // FILL 是填充模式
        // STROKE 是画线模式（即勾边模式）
        // FILL_AND_STROKE 是两种模式一并使用：既画线又填充。它的默认值是 FILL，填充模式。
        paint.style = Paint.Style.FILL_AND_STROKE
        // 在 STROKE 和 FILL_AND_STROKE 下，还可以使用 paint.setStrokeWidth(float width) 来设置线条的宽度
        paint.strokeWidth = 10f
        // 抗锯齿 其他写法 Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.isAntiAlias = true
        // 画个点
        // 设置点的形状 ROUND 画出来是圆形的点，SQUARE 或 BUTT 画出来是方形的点
        paint.strokeCap = Paint.Cap.ROUND
        // 批量画点
        val points = floatArrayOf(0f, 0f, 50f, 50f, 50f, 100f, 100f, 50f, 100f, 100f, 150f, 50f, 150f, 100f)
        //  跳过两个数，即前两个 0
        // 一共绘制 8 个数（4 个点）
        canvas?.drawPoints(points, 2, 8, paint)
    }
}