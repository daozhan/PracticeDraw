package com.dao.practicedraw.fragment

import android.view.View
import com.dao.practicedraw.base.BaseFragment
import com.dao.practicedraw.widget.DrawCircleView

/**
 * 画个圆
 * @author daoz
 * @date :2020/3/30 10:37
 */
class DrawCircleFragment : BaseFragment() {
    override fun initView(): View? {
        return DrawCircleView(context)
    }

}