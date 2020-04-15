package com.dao.practicedraw.fragment

import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.view.View
import com.dao.practicedraw.R
import com.dao.practicedraw.base.BaseFragment
import com.dao.practicedraw.widget.DrawArcView
import com.dao.practicedraw.widget.DrawCircleView
import com.dao.practicedraw.widget.DrawDrawingOrderView
import kotlinx.android.synthetic.main.activity_main.view.*
import org.jetbrains.anko.imageBitmap

/**
 * 绘制顺序
 * @author daoz
 * @date :2020/3/30 10:37
 */
class DrawDrawingOrderFragment : BaseFragment() {
    override fun initView(): View? {
        var imageView = DrawDrawingOrderView(context)
        imageView.imageBitmap = BitmapFactory.decodeResource(resources, R.mipmap.batman)
        return imageView

    }

}