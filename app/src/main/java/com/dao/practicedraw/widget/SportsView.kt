package com.dao.practicedraw.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.dao.practicedraw.utils.dip2Px

/**
 * 画个圆形
 * @author daoz
 * @date :2020/3/30 14:09
 */
class SportsView : View{
    // 初始化Paint对象
    var paint: Paint = Paint()
    private var progress = 0f
    var arcRectF = RectF()

    // 创建 getter 方法
    fun getProgress(): Float {
        return progress
    }

    // 创建 setter 方法
    fun setProgress(progress: Float) {
        this.progress = progress
        invalidate()
    }

    constructor(context: Context?) : super(context)
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
        paint.color = Color.RED
        // 风格
        // FILL 是填充模式
        // STROKE 是画线模式（即勾边模式）
        // FILL_AND_STROKE 是两种模式一并使用：既画线又填充。它的默认值是 FILL，填充模式。
        paint.style = Paint.Style.FILL
        // 在 STROKE 和 FILL_AND_STROKE 下，还可以使用 paint.setStrokeWidth(float width) 来设置线条的宽度
        paint.strokeWidth = 10f
        // 抗锯齿 其他写法 Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.isAntiAlias = true
        // 画一个弧形或扇形
        // drawArc() 是使用一个椭圆来描述弧形的。left, top, right, bottom 描述的是这个弧形所在的椭圆；
        // startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度），
        // sweepAngle 是弧形划过的角度；useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形。
        arcRectF.top = dip2Px(50f)
        arcRectF.bottom = dip2Px(200f)
        arcRectF.left = dip2Px(50f)
        arcRectF.right = dip2Px(250f)
        canvas?.drawArc(arcRectF,180f, progress, true, paint); // 绘制扇形
        arcRectF.top -= dip2Px(10f)
        arcRectF.left += dip2Px(10f)
        arcRectF.right -= dip2Px(10f)
        arcRectF.bottom += dip2Px(10f)

        paint.color = Color.WHITE
        canvas?.drawArc(arcRectF,180f, 180f, true, paint); // 绘制扇形
    }
}

