package com.dao.practicedraw.fragment

import android.view.View
import com.dao.practicedraw.base.BaseFragment
import com.dao.practicedraw.widget.*

/**
 * 画个自定义图形
 * @author daoz
 * @date :2020/3/30 10:37
 */
class DrawPathQuadToFragment : BaseFragment() {
    override fun initView(): View? {
        return DrawPathQuadToView(context)
    }

}