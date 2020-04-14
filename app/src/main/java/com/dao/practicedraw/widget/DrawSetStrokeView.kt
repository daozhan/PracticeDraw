package com.dao.practicedraw.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.dao.practicedraw.utils.dip2Px

/**
 * 画个圆形
 * @author daoz
 * @date :2020/3/30 14:09
 */
class DrawSetStrokeView : View {
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
    val path = Path()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.translate(dip2Px(10f), dip2Px(10f))

        // 颜色
        paint.color = Color.BLACK
        // 风格
        // FILL 是填充模式
        // STROKE 是画线模式（即勾边模式）
        // FILL_AND_STROKE 是两种模式一并使用：既画线又填充。它的默认值是 FILL，填充模式。
        paint.style = Paint.Style.STROKE
        // 在 STROKE 和 FILL_AND_STROKE 下，还可以使用 paint.setStrokeWidth(float width) 来设置线条的宽度
        paint.strokeWidth = 10f
        // 抗锯齿 其他写法 Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.isAntiAlias = true
        paint.strokeCap = Paint.Cap.BUTT
        path.lineTo(dip2Px(50f), 0f)
        canvas?.drawPath(path, paint)

        canvas?.translate(dip2Px(10f), dip2Px(20f))
        paint.strokeCap = Paint.Cap.ROUND
        path.lineTo(dip2Px(100f), 0f)
        canvas?.drawPath(path, paint)

        canvas?.translate(dip2Px(10f), dip2Px(30f))
        paint.strokeCap = Paint.Cap.SQUARE
        path.lineTo(dip2Px(200f), 0f)
        canvas?.drawPath(path, paint)

        canvas?.translate(dip2Px(10f), dip2Px(40f))
        paint.strokeCap = Paint.Cap.ROUND
        path.lineTo(dip2Px(300f), 0f)
        path.lineTo(dip2Px(200f), dip2Px(100f))
        paint.strokeJoin = Paint.Join.ROUND
        canvas?.drawPath(path, paint)
    }
}