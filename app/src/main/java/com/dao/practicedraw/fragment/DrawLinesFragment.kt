package com.dao.practicedraw.fragment

import android.view.View
import com.dao.practicedraw.base.BaseFragment
import com.dao.practicedraw.widget.*

/**
 * 画个椭圆
 * @author daoz
 * @date :2020/3/30 10:37
 */
class DrawLinesFragment : BaseFragment() {
    override fun initView(): View? {
        return DrawLinesView(context)
    }

}