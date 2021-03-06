package com.dao.practicedraw.fragment

import android.view.View
import com.dao.practicedraw.base.BaseFragment
import com.dao.practicedraw.widget.DrawBitmapView
import com.dao.practicedraw.widget.DrawCircleView
import com.dao.practicedraw.widget.DrawTextView

/**
 * 画个圆
 * @author daoz
 * @date :2020/3/30 10:37
 */
class DrawTextFragment : BaseFragment() {
    override fun initView(): View? {
        return DrawTextView(context)
    }

}