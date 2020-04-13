package com.dao.practicedraw.fragment

import android.view.View
import com.dao.practicedraw.base.BaseFragment
import com.dao.practicedraw.widget.DrawCircleView
import com.dao.practicedraw.widget.DrawPointView

/**
 * 画个点
 * @author daoz
 * @date :2020/3/30 10:37
 */
class DrawPointFragment : BaseFragment() {
    override fun initView(): View? {
        return DrawPointView(context)
    }

}