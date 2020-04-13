package com.dao.practicedraw.fragment

import android.view.View
import com.dao.practicedraw.base.BaseFragment
import com.dao.practicedraw.widget.DrawColorView

/**
 * Canvas.drawColor(@ColorInt int color) 颜色填充
 * 这是最基本的 drawXXX() 方法：在整个绘制区域统一涂上指定的颜色。
 * 例如 drawColor(Color.BLACK) 会把整个区域染成纯黑色，覆盖掉原有内容；
 * drawColor(Color.parse("#88880000") 会在原有的绘制效果上加一层半透明的红色遮罩。
 * @author daoz
 * @date :2020/3/30 10:37
 */
class DrawColorFragment : BaseFragment() {
    override fun initView(): View? {
        return DrawColorView(context)
    }

}