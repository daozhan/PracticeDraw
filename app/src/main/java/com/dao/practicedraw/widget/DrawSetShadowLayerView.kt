package com.dao.practicedraw.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.support.v7.widget.ButtonBarLayout
import android.util.AttributeSet
import android.view.View
import com.dao.practicedraw.R
import kotlinx.android.synthetic.main.activity_main.view.*

/**
 * 在之后的绘制内容下面加一层阴影。
 * @author daoz
 * @date :2020/3/30 14:09
 */
class DrawSetShadowLayerView : View {
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
        paint.color = Color.BLACK
        // 风格
        // FILL 是填充模式
        // STROKE 是画线模式（即勾边模式）
        // FILL_AND_STROKE 是两种模式一并使用：既画线又填充。它的默认值是 FILL，填充模式。
        paint.style = Paint.Style.FILL
        // 在 STROKE 和 FILL_AND_STROKE 下，还可以使用 paint.setStrokeWidth(float width) 来设置线条的宽度
        paint.strokeWidth = 10f
        // 抗锯齿 其他写法 Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.isAntiAlias = true
        paint.textSize = 20f

        // 在之后的绘制内容下面加一层阴影
//        paint.setShadowLayer(10f, 0f, 0f, Color.RED)
        canvas?.drawText("PengDaoZhan", 80f, 300f, paint)

        // setMaskFilter(MaskFilter maskfilter)
        // 模糊效果的 MaskFilter。
        paint.maskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.batman)
        canvas?.drawBitmap(bitmap, 300f, 500f, paint)

        paint.maskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID)
        canvas?.drawBitmap(bitmap, 300f, 100f, paint)

        paint.maskFilter = EmbossMaskFilter(floatArrayOf(0f, 1f, 1f), 0.2f, 8f, 10f)
        canvas?.drawBitmap(bitmap, 50f, 500f, paint)
    }
}