package com.dao.practicedraw.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

/**
 * 画个圆形
 * @author daoz
 * @date :2020/3/30 14:09
 */
class DrawTextOnPathView : View {
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
    var paint = TextPaint()
    val linePaint = Paint()

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 颜色
        paint.color = Color.BLACK
        linePaint.color = Color.BLACK
        // 风格
        // FILL 是填充模式
        // STROKE 是画线模式（即勾边模式）
        // FILL_AND_STROKE 是两种模式一并使用：既画线又填充。它的默认值是 FILL，填充模式。
        paint.style = Paint.Style.FILL
        linePaint.style = Paint.Style.STROKE
        // 在 STROKE 和 FILL_AND_STROKE 下，还可以使用 paint.setStrokeWidth(float width) 来设置线条的宽度
        paint.strokeWidth = 2f
        linePaint.strokeWidth = 2f
        // 抗锯齿 其他写法 Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.isAntiAlias = true
        paint.textSize = 40f
        paint.pathEffect = CornerPathEffect(20f)

        canvas?.translate(100f, 100f)

        val path = Path()
        path.lineTo(50f, 150f)
        path.lineTo(100f, 50f)
        path.lineTo(150f, 150f)

        canvas?.drawPath(path, linePaint)
        canvas?.drawTextOnPath("Hello PengDaoZhan ", path, 0f, 0f, paint)

        // 自动换行
        val text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
        val staticLayout = StaticLayout(text, paint, 600, Layout.Alignment.ALIGN_NORMAL, 1f, 0f, true)

        canvas?.drawText(text, 200f, 200f, paint)

        canvas?.translate(200f, 300f)
        staticLayout.draw(canvas)

        // 加粗
        paint.isFakeBoldText = true
        canvas?.drawText(text, 200f, 320f, paint)

        // 下划线
        paint.isUnderlineText = true
        canvas?.drawText(text, 200f, 350f, paint)

        // 倾斜度
        paint.textSkewX = 0.5f
        canvas?.drawText(text, 200f, 380f, paint)

    }
}