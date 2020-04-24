package com.dao.practicedraw

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.method.Touch
import com.dao.practicedraw.adapter.BaseFragmentAdapter
import com.dao.practicedraw.fragment.*
import com.dao.practicedraw.widget.tablayout.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var mFragments = mutableListOf<Fragment>()
    private var titles = arrayOf("drawColor()")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 画颜色
        mFragments.add(DrawColorFragment())
        // 文字加载动画
        addItem("文字加载动画", TextLoadingFragment())
        // 点赞效果
        addItem("点赞效果", LikeImageFragment())
        // 触摸反馈
        addItem("触摸反馈", TouchFeedbackFragment())
        // 属性动画-进阶
        addItem("自定义正方形ImageView", SquareImageViewFragment())
        // 属性动画-进阶
        addItem("属性动画-进阶", PropertyAnimationAdvancedFragment())
        // 属性动画
        addItem("属性动画", PropertyAnimationFragment())
        // 绘制子 View 的方法
        addItem("绘制子View的方法", SpottedLinearLayoutFragment())
        // 绘制顺序
        addItem("绘制顺序", DrawDrawingOrderFragment())
        // getTextBounds
        addItem("翻页效果", DrawTurnPageFragment())
        // getTextBounds
        addItem("Camera", DrawCameraFragment())
        val 正方形 = "100"
        // getTextBounds
        addItem("几何变换", DrawTranslateFragment())
        // getTextBounds
        addItem("范围裁切 clipRect", DrawClipRectFragment())
        // getTextBounds
        addItem("光标相关", DrawGetRunAdvanceFragment())
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
