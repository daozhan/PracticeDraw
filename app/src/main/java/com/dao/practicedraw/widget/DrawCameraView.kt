package com.dao.practicedraw.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.dao.practicedraw.R

/**
 * 使用 Camera 来做三维变换
 * @author daoz
 * @date :2020/3/30 14:09
 */
class DrawCameraView : View {
    private val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.batman)

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
    val camera = Camera()

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

        canvas?.save()

        camera.save()
        // 旋转 Camera 的三维空间
        camera.rotateX(30f)
        // 旋转之后把投影移动回来
        canvas?.translate(250f, 250f)
        // 把旋转投影到 Canvas
        camera.applyToCanvas(canvas)
        // 旋转之前把绘制内容移动到轴心（原点）
        canvas?.translate(-250f, -250f)
        camera.restore()

        canvas?.drawBitmap(bitmap, 100f, 100f, paint)
        canvas?.restore()
    }
}