package com.dao.practicedraw.widget.pictureswitch

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.*
import android.support.annotation.IdRes
import android.util.AttributeSet
import android.view.View
import com.dao.practicedraw.utils.dip2Px

/**
 *
 * @author daoz
 * @date :2020/4/28 15:56
 */

class PictureSwitchBgImage : View {
    private val paint = Paint()
    private var mUnSelectedBitmap: Bitmap? = null
    // 图片宽度
    private var imageWidth = mUnSelectedBitmap?.width?.toFloat()
    // 图片高度
    private var imageHeight = mUnSelectedBitmap?.height?.toFloat()
    private val path = Path()
    // 是否选择 默认为未选中
    private var isSelect = false
    // 动画时间
    private var animationTime = 200
    // 移动的距离
    private var movingDistance = dip2Px(0.3f)

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (imageWidth != null && imageHeight != null) {
            path.reset()
            path.fillType = Path.FillType.INVERSE_WINDING
            path.rLineTo(imageWidth!!, dip2Px(0f))
            path.lineTo(imageWidth!!, movingDistance)
            path.rLineTo(-imageWidth!!, dip2Px(0f))
            path.close()
            canvas?.clipPath(path)
            canvas?.drawBitmap(mUnSelectedBitmap, dip2Px(0f), dip2Px(0f), paint)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(imageWidth?.toInt()!!, imageHeight?.toInt()!!)
    }


    /**
     * 开始动画
     */
    fun startAnimation() {
        if (imageHeight != null) {
            val annotation = ObjectAnimator.ofFloat(
                if(isSelect) imageHeight!! else dip2Px(0.3f),
                if(isSelect) dip2Px(0.3f) else imageHeight!!
            )
            annotation.duration = animationTime.toLong()
            annotation.addUpdateListener {
                movingDistance = it.animatedValue as Float
                invalidate()
            }
            annotation.addListener(object : Animator.AnimatorListener{
                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                    isSelect = !isSelect
                }

                /**
                 * 动画结束
                 */
                override fun onAnimationEnd(animation: Animator?) {
                }
            })
            annotation.start()
        }
    }

    /**
     * 设置未选中图片
     */
    fun setUnSelectBitmapSrc(@IdRes mUnSelectBitmapSrc: Int) {
        mUnSelectedBitmap = BitmapFactory.decodeResource(resources, mUnSelectBitmapSrc)
        imageWidth = mUnSelectedBitmap?.width?.toFloat()
        imageHeight = mUnSelectedBitmap?.height?.toFloat()
        invalidate()
    }
}