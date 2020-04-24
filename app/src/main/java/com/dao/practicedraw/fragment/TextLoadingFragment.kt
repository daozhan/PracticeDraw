package com.dao.practicedraw.fragment

import android.view.View
import android.widget.SeekBar
import com.dao.practicedraw.R
import com.dao.practicedraw.base.BaseFragment
import com.dao.practicedraw.utils.ScreenUtils
import kotlinx.android.synthetic.main.frg_text_loading.*
import org.jetbrains.anko.internals.AnkoInternals.addView


/**
 * 属性动画
 * @author daoz
 * @date :2020/3/30 10:37
 */
class TextLoadingFragment : BaseFragment() {

    override fun initView(): View? {
        return View.inflate(context, R.layout.frg_text_loading, null)
    }

    override fun initListener() {
        super.initListener()
        start.setOnClickListener {
            text_loading_view.startAnimation()
        }
    }

}

