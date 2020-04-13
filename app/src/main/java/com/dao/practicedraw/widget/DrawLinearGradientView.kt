package com.dao.practicedraw.widget

import android.content.Context
import android.graphics.*
import android.graphics.Color.parseColor
import android.util.AttributeSet
import android.view.View

/**
 * 画个圆形  LinearGradient 线性渐变
 * @author daoz
 * @date :2020/3/30 14:09
 */
class DrawLinearGradientView : View{
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
        // 风格
        // FILL 是填充模式
        // STROKE 是画线模式（即勾边模式）
        // FILL_AND_STROKE 是两种模式一并使用：既画线又填充。它的默认值是 FILL，填充模式。
        paint.style = Paint.Style.FILL
        // 在 STROKE 和 FILL_AND_STROKE 下，还可以使用 paint.setStrokeWidth(float width) 来设置线条的宽度
        paint.strokeWidth = 10f
        // 抗锯齿 其他写法 Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.isAntiAlias = true
        // 颜色 LinearGradient 线性渐变
        val shader = LinearGradient(0f, 0f, 200f, 200f,parseColor("#E91E63"),
            parseColor("#2196F3"), Shader.TileMode.CLAMP)
        paint.shader = shader
        canvas?.drawCircle(100f, 100f, 100f, paint)
        // RadialGradient 辐射渐变
        val shader2 = RadialGradient(300f, 300f,  200f,parseColor("#E91E63"),
            parseColor("#2196F3"), Shader.TileMode.REPEAT)
        paint.shader = shader2
        canvas?.drawCircle(300f, 300f, 100f, paint)
        // SweepGradient 扫描渐变
        val shader3 = SweepGradient(500f, 500f,parseColor("#E91E63"),
            parseColor("#2196F3"))
        paint.shader = shader3
        canvas?.drawCircle(500f, 500f, 100f, paint)
    }
}