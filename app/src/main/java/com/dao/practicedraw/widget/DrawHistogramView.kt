package com.dao.practicedraw.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import android.graphics.RectF
import com.dao.practicedraw.utils.dip2Px
import android.R.attr.angle
import android.util.Log
import org.w3c.dom.Text
import com.dao.practicedraw.widget.bean.PieChartViewBean
import org.jetbrains.anko.db.NULL

/**
 *
 * @author daoz
 * @date :2020/3/30 14:09
 */
class DrawHistogramView : View {
    private val mColors = intArrayOf(
        Color.BLUE,
        Color.DKGRAY,
        Color.CYAN,
        Color.YELLOW,
        Color.GRAY,
        Color.RED,
        Color.GREEN
    )
    // View宽高
    private var w: Int = 0
    private var h: Int = 0
    // 矩形
    private var rectF: RectF = RectF()
    var paint: Paint = Paint()
    // 数据集
    private var viewDatas: ArrayList<PieChartViewBean> = ArrayList()

    constructor(context: Context?) : super(context) {
        initPaint()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        this.w = w;     //获取宽高
        this.h = h;
    }


    // 设置数据
    fun setData(viewDatas: ArrayList<PieChartViewBean>) {
        this.viewDatas = viewDatas
        // 刷新UI
        invalidate()
    }

    // 初始化画笔
    private fun initPaint() {
        paint = Paint()
        // 设置画笔默认颜色
        paint.color = Color.BLACK
        textPaint.color = Color.BLACK
        // 设置画笔模式：填充
        paint.style = Paint.Style.STROKE
        textPaint.style = Paint.Style.STROKE
        // 抗锯齿
        paint.isAntiAlias = true
        // 文字大小
        paint.textSize = dip2Px(14f)
        textPaint.textSize = dip2Px(14f)
    }

    // 初始化Paint对象
    var textPaint: Paint = Paint()

    var linePath: Path = Path()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        linePath.moveTo(dip2Px(50f), dip2Px(50f))
        linePath.lineTo(dip2Px(50f), dip2Px(300f))
        linePath.rLineTo(dip2Px(300f), dip2Px(0f))
        canvas?.drawPath(linePath, textPaint)
        // 第一个
        var left = dip2Px(60f)
        var top = dip2Px(100f)
        var right = dip2Px(100f)
        var bottom = dip2Px(300f)

        paint.style = Paint.Style.FILL
        paint.color = Color.GREEN

        for (int in 0 until 6) {
            canvas?.drawRect(left, top, right, bottom, paint)
            canvas?.drawText("test", left, bottom + dip2Px(10f), textPaint)
            left += dip2Px(50f)
            top += dip2Px(20f)
            right += dip2Px(50f)
        }

    }

}

