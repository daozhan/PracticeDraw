package com.dao.practicedraw.widget

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import android.widget.TextView
import com.dao.practicedraw.R
import com.dao.practicedraw.utils.dip2Px
import kotlinx.android.synthetic.main.frg_square_imageview.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.padding
import org.jetbrains.anko.textColor

/**
 *
 * @author daoz
 * @date :2020/4/24 17:04
 */
class TextLoadingView : FrameLayout {
    private val textView = MyNoPaddingTextView(context)
    private val loadingView = LoadingView(context)

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        val custom = context?.obtainStyledAttributes(attrs, R.styleable.TextLoadingView, defStyleAttr, 0)
        val text = custom?.getText(R.styleable.TextLoadingView_text)
        textView.text = text.toString()
        val layoutParams = LayoutParams(textView.layoutParams)
        layoutParams.width = WRAP_CONTENT
        layoutParams.height = WRAP_CONTENT
        textView.layoutParams = layoutParams
        loadingView.text = text.toString()
        val layoutParams2 = LayoutParams(loadingView.layoutParams)
        layoutParams.width = WRAP_CONTENT
        layoutParams.height = WRAP_CONTENT
        loadingView.layoutParams = layoutParams2
    }

    init {
        addView(textView)
        addView(loadingView)
    }

    fun startAnimation() {
        loadingView.startAnimation()
    }

}