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
class TouchFeedbackFragment : BaseFragment(), SeekBar.OnSeekBarChangeListener {
    var minWidth = ScreenUtils.dpToPixel(80f)
    var minHeight = ScreenUtils.dpToPixel(100f)

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }

    override fun initView(): View? {
        return View.inflate(context, R.layout.frg_touch_feedback, null)
    }

    override fun initListener() {
        super.initListener()
    }


}

