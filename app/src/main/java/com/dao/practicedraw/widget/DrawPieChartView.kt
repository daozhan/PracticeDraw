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
 * 画个圆形
 * @author daoz
 * @date :2020/3/30 14:09
 */
class DrawPieChartView : View {
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
        // 设置数据的百分度和角度
        initData()
        // 刷新UI
        invalidate()
    }

    // 初始化画笔
    private fun initPaint() {
        paint = Paint()
        // 设置画笔默认颜色
        paint.color = Color.WHITE
        // 设置画笔模式：填充
        paint.style = Paint.Style.FILL
        // 抗锯齿
        paint.isAntiAlias = true
        // 文字大小
        paint.textSize = dip2Px(10f)
        // 初始化区域
        rectF = RectF()
    }

    // 初始化Paint对象
    var TextPaint: Paint = Paint()

    var LinePath: Path = Path()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val r = (Math.min(w, h) / 4).toFloat()     //饼状图半径(取宽高里最小的值)
        var currentStartAngle = 0f                //起始角度
        rectF.set(-r, -r, r, r)                    //设置将要用来画扇形的矩形的轮廓
        canvas?.translate((w / 2).toFloat(), (h / 2).toFloat())

//        canvas?.drawArc(rectF, -190f, 130f, true, paint)
//        val textAngle = -190f + 130f / 2    //计算文字位置角度
//        val x = (r * Math.cos(textAngle * Math.PI / 180)).toFloat()    //计算文字位置坐标
//        val y = (r * Math.sin(textAngle * Math.PI / 180)).toFloat()
//        LinePath.moveTo(x, y)
//        LinePath.lineTo(x - dip2Px(10f), y - dip2Px(10f))
//        LinePath.rLineTo(-dip2Px(60f), 0f)
//        canvas?.drawPath(LinePath, TextPaint)
//        TextPaint.textSize = dip2Px(14f)
//        canvas?.drawText("红色", x - dip2Px(100f), y - dip2Px(5f), TextPaint);    //绘制文字
//        canvas?.translate(dip2Px(10f), dip2Px(10f))

        for (i in 0 until viewDatas.size) {
            val viewData = viewDatas[i]
            paint.color = viewData.color
            paint.style = Paint.Style.FILL

            //绘制扇形(通过绘制圆弧)
            canvas?.drawArc(rectF, currentStartAngle, viewData.angle, true, paint)
            //绘制扇形上文字
            val textAngle = currentStartAngle + viewData.angle / 2    //计算文字位置角度
            val x = (r * Math.cos(textAngle * Math.PI / 180)).toFloat()    //计算文字位置坐标
            val y = (r * Math.sin(textAngle * Math.PI / 180)).toFloat()
            // 文字颜色
            paint.color = Color.BLACK
            paint.style = Paint.Style.STROKE
            LinePath.moveTo(x, y)
            // X轴变化
            var varietyX: Float = 0f
            var varietyHorizontalX: Float = 0f
            var varietyTextX: Float = 0f
            // Y轴变化
            var varietyY: Float = 0f
            var varietyTextY: Float = 0f

            if (currentStartAngle >= 0 && currentStartAngle < 80) {
                varietyX = dip2Px(10f)
                varietyY = dip2Px(10f)
                varietyHorizontalX = dip2Px(40f)
                varietyTextX = varietyHorizontalX + varietyX
                varietyTextY = dip2Px(10f)
            } else if (currentStartAngle >= 80 && currentStartAngle < 180) {
                varietyX = -dip2Px(10f)
                varietyY = dip2Px(10f)
                varietyHorizontalX = -dip2Px(40f)
                varietyTextX = -(-varietyHorizontalX - varietyX - varietyHorizontalX)
                varietyTextY = dip2Px(10f)
            } else if (currentStartAngle >= 180 && currentStartAngle < 270) {
                varietyX = -dip2Px(10f)
                varietyY = -dip2Px(10f)
                varietyHorizontalX = -dip2Px(40f)
                varietyTextX = -(-varietyHorizontalX - varietyX - varietyHorizontalX)
                varietyTextY = -dip2Px(10f)
            } else if (currentStartAngle >= 270 && currentStartAngle < 360) {
                varietyX = dip2Px(10f)
                varietyY = -dip2Px(10f)
                varietyHorizontalX = dip2Px(40f)
                varietyTextX = varietyHorizontalX + varietyX
                varietyTextY = -dip2Px(10f)
            }

            LinePath.lineTo(x + varietyX, y + varietyY)
            LinePath.rLineTo(varietyHorizontalX, 0f)
            canvas?.drawPath(LinePath, paint)
            canvas?.drawText(viewData.name, x + varietyTextX, y + varietyTextY, paint)    //绘制文字

            currentStartAngle += viewData.angle     //改变起始角度
        }
    }


    private fun initData() {
        // 数值和
        var sumValue = 0f
        for (i in 0 until viewDatas.size) {
            val viewData = viewDatas[i]
            sumValue += viewData.value.toFloat()
            // 设置颜色
            val j = i % mColors.size
            viewData.color = mColors[j]
        }

        for (data in viewDatas) {
            // 计算百分比
            val percentage = data.value / sumValue
            // 对应的角度
            val angle = percentage * 360
            data.percentage = percentage
            data.angle = angle
        }
    }
}