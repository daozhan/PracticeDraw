package com.dao.practicedraw.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.dao.practicedraw.utils.dip2Px

/**
 * 画个圆形
 * @author daoz
 * @date :2020/3/30 14:09
 */
class SpottedLinearLayoutView : LinearLayout {
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

    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        // 颜色
        paint.color = Color.RED
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true

        val centerX = width / 2
        val centerY = height / 2

        canvas?.drawCircle(centerX - dip2Px(50f), centerY - dip2Px(50f), dip2Px(5f), paint)
        canvas?.drawCircle(centerX - dip2Px(20f), centerY - dip2Px(10f), dip2Px(10f), paint)
        canvas?.drawCircle(centerX + dip2Px(50f), centerY - dip2Px(50f), dip2Px(10f), paint)
        canvas?.drawCircle(centerX + dip2Px(50f), centerY + dip2Px(50f), dip2Px(20f), paint)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onDrawForeground(canvas: Canvas?) {

        super.onDrawForeground(canvas)

    }
}