package com.dao.practicedraw.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import com.dao.practicedraw.utils.dip2Px

/**
 *
 * @author daoz
 * @date :2020/4/18 14:03
 */
class SquareImageView : ImageView {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        // 获取高度和宽度
        var width = measuredWidth
        var height = measuredHeight
        // 重新调整
        if (width > height){
            width = height
        }else{
            height = width
        }
        // 设置宽高
        setMeasuredDimension(width, height)

    }
}