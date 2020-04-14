package com.dao.practicedraw

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.dao.practicedraw.adapter.BaseFragmentAdapter
import com.dao.practicedraw.fragment.*
import com.dao.practicedraw.widget.tablayout.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    private var mFragments = mutableListOf<Fragment>()
    private var titles = arrayOf("drawColor()")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 画颜色
        mFragments.add(DrawColorFragment())
        // getTextBounds
        addItem("getTextBounds", DrawGetTextBoundsFragment())
        // getFillPath
        addItem("drawTextOnPath", DrawTextOnPathFragment())
        // getFillPath
        addItem("getFillPath", DrawGetFillPathFragment())
        // setStroke
        addItem("setShadowLayer", DrawSetShadowLayerFragment())
        // setStroke
        addItem("setPathEffect", DrawSetPathEffectFragment())
        // setStroke
        addItem("setStroke", DrawSetStrokeFragment())
        // setXfermode
        addItem("setXfermode", DrawSetXfermodeFragment())
        // setColorFilter
        addItem("setColorFilter", DrawSetColorFilterFragment())
        // BitmapShader
        addItem("BitmapShader", DrawBitmapShaderFragment())
        // 设置渐变颜色
        addItem("setShader 设置渐变颜色", DrawLinearGradientFragment())
        // 直方图
        addItem("直方图", DrawHistogramFragment())
        // 饼图
        addItem("饼图", DrawPieChartFragment())
        // 画绘制文字
        addItem("drawText()", DrawTextFragment())
        // 画Bitmap
        addItem("drawBitmap()", DrawBitmapFragment())
        // 画个自定义图形-画二次贝塞尔曲线
        addItem("quadTo()", DrawPathQuadToFragment())
        // 画个自定义图形-添加一条线
        addItem("lineTo()", DrawPathLineToFragment())
        // 画个自定义图形-添加一个圆
        addItem("addCircle()", DrawPathAddCircleFragment())
        // 画个自定义图形
        addItem("drawPath()", DrawPathFragment())
        // 画一个弧形或扇形
        addItem("drawArc()", DrawArcFragment())
        // 画个圆角矩形
        addItem("drawRoundRect()", DrawRoundRectFragment())
        // 画条线
        addItem("drawLines()", DrawLinesFragment())
        // 画条线
        addItem("drawLine()", DrawLineFragment())
        // 画个椭圆
        addItem("drawOval()", DrawOvalFragment())
        // 画多个点
        addItem("drawPoints()", DrawPointsFragment())
        // 画个点
        addItem("drawPoint()", DrawPointFragment())
        // 画个矩形
        addItem("drawRect()", DrawRectFragment())
        // 画个圆
        addItem("drawCircle()", DrawCircleFragment())


        val mAdapter = BaseFragmentAdapter(getSupportFragmentManager(), titles, mFragments)
        act_main_vp.adapter = mAdapter
        act_main_tb.tabGravity = TabLayout.GRAVITY_FILL
        act_main_tb.isNeedSwitchAnimation = true
//        act_main_tb.selectedTabIndicatorWidth = dpToPx(40)
        act_main_tb.setIndicatorWidthWrapContent(true)
        act_main_tb.setupWithViewPager(act_main_vp)
    }

    /**
     * 增加
     * @item：需添加数值
     * */
    private fun addItem(item: String, fragment: Fragment) {
        val newArr = Array<String>(titles.size + 1) { it.toString() }
        for (i in titles.indices) {
            newArr[i] = titles[i]
        }
        newArr[titles.size] = item
        titles = newArr

        mFragments.add(fragment)
    }

    private fun dpToPx(dps: Int): Int {
        return Math.round(resources.displayMetrics.density * dps)
    }

}