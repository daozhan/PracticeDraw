package com.dao.practicedraw.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.BitmapFactory.decodeResource
import android.util.AttributeSet
import android.view.View
import com.dao.practicedraw.R

/**
 * 画个圆形
 * @author daoz
 * @date :2020/3/30 14:09
 */
class DrawBitmapShaderView : View {
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
        // 第一个 Shader：头像的 Bitmap
        val bitmap = decodeResource(resources, R.mipmap.batman)
        val shader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        // 第二个 Shader：从上到下的线性渐变（由透明到黑色）
        val bitmap2 = decodeResource(resources, R.mipmap.batman_logo)
        val shader2 = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        paint.shader = shader
        canvas?.drawCircle(135f, 120f, 100f, paint)
        // 结合使用
        val shader3 = ComposeShader(shader, shader2, PorterDuff.Mode.SRC_OVER)
        paint.shader = shader

        canvas?.drawCircle(235f, 220f, 100f, paint)

    }
}