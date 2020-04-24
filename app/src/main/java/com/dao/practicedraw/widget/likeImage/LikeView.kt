package com.dao.practicedraw.widget.likeImage

import android.content.Context
import android.util.AttributeSet
import android.util.Log
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
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val custom = context?.obtainStyledAttributes(attrs, R.styleable.LikeView, defStyleAttr, 0)
        val likeSrc = custom?.getResourceId(R.styleable.LikeView_likeSrc, R.mipmap.batman)
        val unLikeSrc = custom?.getResourceId(R.styleable.LikeView_unlikeSrc, R.mipmap.batman)
        if (likeSrc != null) {
            likeImageView.setLikeSrc(likeSrc)
        }
        if (unLikeSrc != null) {
            likeImageView.setUnLikeSrc(unLikeSrc)
        }
    }

    init {
        orientation = HORIZONTAL
        Log.e("peng", "unLikeSrc===  ")
        addView(likeImageView)
        addView(likeNumView)
    }
}