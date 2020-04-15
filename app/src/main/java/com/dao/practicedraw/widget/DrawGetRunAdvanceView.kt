package com.dao.practicedraw.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View

/**
 * 画个圆形
 * @author daoz
 * @date :2020/3/30 14:09
 */
class DrawGetRunAdvanceView : View {
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

    @RequiresApi(Build.VERSION_CODES.M)
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
        paint.strokeWidth = 1f
        paint.textSize = 50f
        // 抗锯齿 其他写法 Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.isAntiAlias = true
        val text = "PengDaoZhan"
        val length = text.length
        val offsetX = 100f
        val offsetY = 100f
        // 对于一段文字，计算出某个字符处光标的 x 坐标。 start end 是文字的起始和结束坐标；
        // contextStart contextEnd 是上下文的起始和结束坐标；isRtl 是文字的方向；offset 是字数的偏移，即计算第几个字符处的光标。
        val advance = paint.getRunAdvance(text, 0, length, 0, length, false, length)
        canvas?.drawText(text, offsetX, offsetY, paint)
        canvas?.drawLine(offsetX + advance, offsetY - 50, offsetX + advance, offsetY + 10, paint)
    }
}