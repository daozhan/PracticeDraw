package com.dao.practicedraw.fragment

import android.view.View
import com.dao.practicedraw.base.BaseFragment
import com.dao.practicedraw.widget.DrawArcView
import com.dao.practicedraw.widget.DrawCircleView
import com.dao.practicedraw.widget.DrawPathLineToView
import com.dao.practicedraw.widget.DrawPathView

/**
 * 画个自定义图形
 * @author daoz
 * @date :2020/3/30 10:37
 */
class DrawPathLineToFragment : BaseFragment() {
    override fun initView(): View? {
        return DrawPathLineToView(context)
    }

}