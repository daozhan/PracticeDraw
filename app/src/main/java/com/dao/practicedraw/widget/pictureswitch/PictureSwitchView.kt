package com.dao.practicedraw.widget.pictureswitch

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.FrameLayout
import com.dao.practicedraw.R
import com.dao.practicedraw.R.attr.likeSrc
import kotlin.math.max

/**
 *
 * @author daoz
 * @date :2020/4/28 15:55
 */
class PictureSwitchView : FrameLayout {
    private val pictureSwitchImage = PictureSwitchImage(context)
    private val pictureSwitchBgImage = PictureSwitchBgImage(context)
    private var isSelect = false

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val custom = context?.obtainStyledAttributes(attrs, R.styleable.PictureSwitchView, defStyleAttr, 0)
        val selectSrc = custom?.getResourceId(R.styleable.PictureSwitchView_selectSrc, R.mipmap.batman)
        val unSelectSrc = custom?.getResourceId(R.styleable.PictureSwitchView_unSelectSrc, R.mipmap.batman_logo)
        if (selectSrc != null) {
            pictureSwitchImage.setSelectBitmapSrc(selectSrc)
        }
        if (unSelectSrc != null) {
            pictureSwitchBgImage.setUnSelectBitmapSrc(unSelectSrc)
        }
    }

    init {
        addView(pictureSwitchBgImage)
        addView(pictureSwitchImage)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        measureChildren(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(
            max(pictureSwitchBgImage.measuredWidth, pictureSwitchImage.measuredWidth),
            max(pictureSwitchBgImage.measuredHeight, pictureSwitchImage.measuredHeight)
        )
    }

    fun startAnimation() {
        pictureSwitchImage.startAnimation()
        pictureSwitchBgImage.startAnimation()
    }

}