package com.dao.practicedraw.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.net.wifi.hotspot2.PasspointConfiguration
import android.util.AttributeSet
import android.view.View

/**
 * 画个圆形
 * @author daoz
 * @date :2020/3/30 14:09
 */
class DrawSetPathEffectView : View {
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
        paint.color = Color.RED
        // 风格
        // FILL 是填充模式
        // STROKE 是画线模式（即勾边模式）
        // FILL_AND_STROKE 是两种模式一并使用：既画线又填充。它的默认值是 FILL，填充模式。
        paint.style = Paint.Style.STROKE
        // 在 STROKE 和 FILL_AND_STROKE 下，还可以使用 paint.setStrokeWidth(float width) 来设置线条的宽度
        paint.strokeWidth = 5f
        // 抗锯齿 其他写法 Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.isAntiAlias = true

        // 使用 PathEffect 来给图形的轮廓设置效果。对 Canvas 所有的图形绘制有效，也就是 drawLine() drawCircle() drawPath() 这些方法。大概像这样：
        val pathEffect = DashPathEffect(floatArrayOf(10f, 5f), 10f)
        paint.pathEffect = pathEffect
        canvas?.drawCircle(600f, 600f, 200f, paint)

        // 把所有拐角变成圆角
        paint.pathEffect = CornerPathEffect(20f)
        val path = Path()
        path.lineTo(80f, 100f)
        path.lineTo(160f, 50f)
        path.lineTo(200f, 100f)
        path.lineTo(260f, 50f)
        path.lineTo(300f, 100f)
        path.lineTo(360f, 50f)
        canvas?.drawPath(path, paint)


        // 把线条进行随机的偏离，让轮廓变得乱七八糟。乱七八糟的方式和程度由参数决定。
        paint.pathEffect = DiscretePathEffect(20f, 5f)
        val path2 = Path()
        path2.lineTo(80f, 200f)
        path2.lineTo(160f, 150f)
        path2.lineTo(200f, 200f)
        path2.lineTo(260f, 150f)
        path2.lineTo(300f, 200f)
        path2.lineTo(360f, 150f)
        canvas?.drawPath(path2, paint)

        // 使用虚线来绘制线条。
        paint.pathEffect = DashPathEffect(floatArrayOf(10f, 5f), 10f)
        val path3 = Path()
        path3.lineTo(80f, 300f)
        path3.lineTo(160f, 250f)
        path3.lineTo(200f, 300f)
        path3.lineTo(260f, 250f)
        path3.lineTo(300f, 300f)
        path3.lineTo(360f, 250f)
        canvas?.drawPath(path3, paint)

        // 这个方法比 DashPathEffect 多一个前缀 Path ，所以顾名思义，它是使用一个 Path 来绘制「虚线」。具体看图吧：
        val dashPath = Path()
        dashPath.lineTo(10f, 10f)
        dashPath.rLineTo(-15f, 0f)
        dashPath.close()
        paint.pathEffect = PathDashPathEffect(dashPath, 15f, 0f, PathDashPathEffect.Style.MORPH)
        val path4 = Path()
        path4.lineTo(80f, 400f)
        path4.lineTo(160f, 350f)
        path4.lineTo(200f, 400f)
        path4.lineTo(260f, 350f)
        path4.lineTo(300f, 400f)
        path4.lineTo(360f, 350f)
        canvas?.drawPath(path4, paint)
        canvas?.drawRoundRect(80f, 800f, 480f, 950f, 20f, 20f, paint)

        // 这是一个组合效果类的 PathEffect 。它的行为特别简单，就是分别按照两种 PathEffect 分别对目标进行绘制。
        paint.pathEffect = SumPathEffect(
            DashPathEffect(floatArrayOf(10f, 5f), 10f)
            , DiscretePathEffect(20f, 5f)
        )
        val path5 = Path()
        path5.lineTo(80f, 500f)
        path5.lineTo(160f, 450f)
        path5.lineTo(200f, 500f)
        path5.lineTo(260f, 450f)
        path5.lineTo(300f, 500f)
        path5.lineTo(360f, 450f)
        canvas?.drawPath(path5, paint)

        // 这也是一个组合效果类的 PathEffect 。不过它是先对目标 Path 使用一个 PathEffect，然后再对这个改变后的 Path 使用另一个 PathEffect。
        paint.pathEffect = ComposePathEffect(
            DashPathEffect(floatArrayOf(10f, 5f), 10f)
            , DiscretePathEffect(20f, 5f)
        )
        val path6 = Path()
        path6.lineTo(80f, 600f)
        path6.lineTo(160f, 550f)
        path6.lineTo(200f, 600f)
        path6.lineTo(260f, 550f)
        path6.lineTo(300f, 600f)
        path6.lineTo(360f, 550f)
        canvas?.drawPath(path6, paint)
    }
}