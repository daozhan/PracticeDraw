package com.dao.practicedraw.fragment

import android.view.View
import com.dao.practicedraw.base.BaseFragment
import com.dao.practicedraw.widget.DrawArcView
import com.dao.practicedraw.widget.DrawCircleView
import com.dao.practicedraw.widget.DrawPathView
import com.dao.practicedraw.widget.DrawPieChartView
import com.dao.practicedraw.widget.bean.PieChartViewBean

/**
 * 饼图
 * @author daoz
 * @date :2020/3/30 10:37
 */
class DrawPieChartFragment : BaseFragment() {
    override fun initView(): View? {
        val drawPieChartView = DrawPieChartView(context)
        val list = arrayListOf<PieChartViewBean>(
            PieChartViewBean(5,"第一类"),
            PieChartViewBean(10,"第二类"),
            PieChartViewBean(10,"第三类"),
            PieChartViewBean(55,"第四类"),
            PieChartViewBean(100,"第五类"),
            PieChartViewBean(120,"第六类"),
            PieChartViewBean(60,"第七类")
        )

        drawPieChartView.setData(list)

        return drawPieChartView
    }

}