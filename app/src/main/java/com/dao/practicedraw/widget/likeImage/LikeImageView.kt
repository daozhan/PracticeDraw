package com.dao.practicedraw.widget.likeImage

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.graphics.Bitmap
import android.support.annotation.IdRes
import android.util.Log
import com.dao.practicedraw.R
import kotlinx.android.synthetic.main.activity_main.view.*
import org.jetbrains.anko.db.REAL


/**
 *
 * @author daoz
 * @date :2020/4/20 16:20
 */
class LikeImageView : View {
    private val mImagePaint = Paint()
    // 是否点赞
    var isLike = false
    // 点赞图片
    var mLikeBitmap: Bitmap? = null
    // 未点赞图片
    private var mUnLikeBitmap: Bitmap? = null
    // 闪光图片
    private var mShiningBitmap: Bitmap? = null

    init {
        mImagePaint.color = Color.parseColor("#C3C4C3")
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
        drawImage(canvas)
    }

    private fun drawImage(canvas: Canvas?) {
        var bitmap: Bitmap? = null
        if (isLike) {
            bitmap = mLikeBitmap
        } else {
            bitmap = mUnLikeBitmap
        }
        Log.e("dao" , "mLikeBitmap===>$mLikeBitmap")
        Log.e("dao" , "mUnLikeBitmap===>$mUnLikeBitmap")
        Log.e("dao" , "bitmap===>$bitmap")
        canvas?.save()
        if (bitmap != null){
            canvas?.drawBitmap(bitmap, 0f, 0f, mImagePaint)
        }
        canvas?.restore()
    }

    /**
     * 设置点赞图片
     */
    fun setLikeSrc(@IdRes likeSrc: Int) {
        mLikeBitmap = BitmapFactory.decodeResource(resources, likeSrc)
    }

    /**
     * 设置点赞取消图片
     */
    fun setUnLikeSrc(@IdRes unLikeSrc: Int) {
        mUnLikeBitmap = BitmapFactory.decodeResource(resources, unLikeSrc)
        Log.e("dao" , "setUnLikeSrc mUnLikeBitmap===>$mUnLikeBitmap")
    }

    /**
     * 设置点赞闪光图片
     */
    fun setShiningSrc(shiningSrc: Int) {
        mShiningBitmap = BitmapFactory.decodeResource(resources, shiningSrc)
    }


}