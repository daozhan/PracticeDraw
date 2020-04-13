package com.dao.practicedraw.fragment

import android.view.View
import com.dao.practicedraw.base.BaseFragment
import com.dao.practicedraw.widget.DrawCircleView
import com.dao.practicedraw.widget.DrawRectView

/**
 * 画个矩形
 * @author daoz
 * @date :2020/3/30 10:37
 */
class DrawRectFragment : BaseFragment() {
    override fun initView(): View? {
        return DrawRectView(context)
    }

}