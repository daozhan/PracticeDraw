package com.dao.practicedraw.fragment

import android.view.View
import android.widget.SeekBar
import com.dao.practicedraw.R
import com.dao.practicedraw.base.BaseFragment
import com.dao.practicedraw.utils.ScreenUtils
import kotlinx.android.synthetic.main.frg_picture_switch.*
import kotlinx.android.synthetic.main.frg_text_loading.*
import kotlinx.android.synthetic.main.frg_text_loading.start
import org.jetbrains.anko.internals.AnkoInternals.addView


/**
 * 属性动画
 * @author daoz
 * @date :2020/3/30 10:37
 */
class PictureSwitchFragment : BaseFragment() {

    override fun initView(): View? {
        return View.inflate(context, R.layout.frg_picture_switch, null)
    }

    override fun initListener() {
        super.initListener()
        start.setOnClickListener{
            pictureSwitchView.startAnimation()
        }
    }

}

