package com.dao.practicedraw.widget.likeImage

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.dao.practicedraw.R

/**
 *
 * @author daoz
 * @date :2020/4/20 17:27
 */
class LikeView : LinearLayout {
    private var likeImageView = LikeImageView(context)
    private var likeNumView = LikeNumView(context)

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        val custom = context?.obtainStyledAttributes(attrs, R.styleable.LikeView, defStyleAttr, 0)
        val likeSrc = custom?.getResourceId(R.styleable.)
        likeImageView.setLikeSrc()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    init{
        orientation = HORIZONTAL
        addView(likeImageView)
        addView(likeNumView)
    }
}