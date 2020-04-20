package com.dao.practicedraw.fragment

import android.view.View
import android.widget.SeekBar
import com.dao.practicedraw.R
import com.dao.practicedraw.base.BaseFragment
import com.dao.practicedraw.utils.ScreenUtils


/**
 * 属性动画
 * @author daoz
 * @date :2020/3/30 10:37
 */
class LikeImageFragment : BaseFragment(), SeekBar.OnSeekBarChangeListener {

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }

    override fun initView(): View? {
        return View.inflate(context, R.layout.frg_like_image, null)
    }

    override fun initListener() {
        super.initListener()
    }


}

