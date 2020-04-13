package com.dao.practicedraw.fragment

import android.view.View
import com.dao.practicedraw.base.BaseFragment
import com.dao.practicedraw.widget.DrawCircleView
import com.dao.practicedraw.widget.DrawLineView
import com.dao.practicedraw.widget.DrawOvalView
import com.dao.practicedraw.widget.DrawPointView

/**
 * 画个椭圆
 * @author daoz
 * @date :2020/3/30 10:37
 */
class DrawLineFragment : BaseFragment() {
    override fun initView(): View? {
        return DrawLineView(context)
    }

}