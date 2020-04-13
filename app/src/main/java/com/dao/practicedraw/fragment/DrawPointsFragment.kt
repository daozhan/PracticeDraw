package com.dao.practicedraw.fragment

import android.view.View
import com.dao.practicedraw.base.BaseFragment
import com.dao.practicedraw.widget.DrawCircleView
import com.dao.practicedraw.widget.DrawPointView
import com.dao.practicedraw.widget.DrawPointsView

/**
 * 画多个点
 * @author daoz
 * @date :2020/3/30 10:37
 */
class DrawPointsFragment : BaseFragment() {
    override fun initView(): View? {
        return DrawPointsView(context)
    }

}