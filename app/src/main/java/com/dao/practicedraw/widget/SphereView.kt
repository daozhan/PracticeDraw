package com.dao.practicedraw.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.dao.practicedraw.utils.dip2Px

/**
 *
 * @author daoz
 * @date :2020/4/16 9:41
 */
class SphereView : View {
    val paint = Paint()
    private var color = 0xffff0000

    fun setColor(color: Int){
        this.color = color.toLong()
        invalidate()
    }

    constructor(context: Context?) : super(context) {
        init()
    }

    private fun init() {
//        paint.style = Paint.Style.FILL
//        paint.color = Color.BLUE
//        paint.isAntiAlias = true
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
        // 颜色
        paint.color = color.toInt()
        // 风格
        // FILL 是填充模式
        // STROKE 是画线模式（即勾边模式）
        // FILL_AND_STROKE 是两种模式一并使用：既画线又填充。它的默认值是 FILL，填充模式。
        paint.style = Paint.Style.FILL
        // 在 STROKE 和 FILL_AND_STROKE 下，还可以使用 paint.setStrokeWidth(float width) 来设置线条的宽度
        // 抗锯齿 其他写法 Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.isAntiAlias = true
        canvas?.drawCircle((width/2).toFloat(), (height/2).toFloat(), dip2Px(50f), paint)
    }
}