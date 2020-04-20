package com.dao.practicedraw.fragment

import android.annotation.SuppressLint
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import com.dao.practicedraw.R
import com.dao.practicedraw.base.BaseFragment
import kotlinx.android.synthetic.main.frg_square_imageview.*
import java.util.*
import android.util.DisplayMetrics
import android.widget.LinearLayout
import android.R.attr.minHeight
import android.opengl.ETC1.getHeight
import android.R.attr.minWidth
import android.opengl.ETC1.getWidth
import android.view.ViewGroup
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.view.WindowManager
import com.dao.practicedraw.utils.ScreenUtils


/**
 * 属性动画
 * @author daoz
 * @date :2020/3/30 10:37
 */
class SquareImageViewFragment : BaseFragment(), SeekBar.OnSeekBarChangeListener {
    var minWidth = ScreenUtils.dpToPixel(80f)
    var minHeight = ScreenUtils.dpToPixel(100f)

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        val dm = resources.displayMetrics
        val width = dm.widthPixels
        val height = dm.heightPixels

        val layoutParams = square_image_ll.layoutParams
        layoutParams.width = (minWidth + (width - minWidth.toInt()) * width_seek_bar.progress / 100).toInt()
        layoutParams.height = (minHeight + (height - minHeight.toInt()) * height_seek_bar.progress / 100).toInt()

        square_image_ll.layoutParams = layoutParams
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }

    override fun initView(): View? {
        return View.inflate(context, R.layout.frg_square_imageview, null)

    }

    override fun initListener() {
        super.initListener()
        width_seek_bar.setOnSeekBarChangeListener(this)
        height_seek_bar.setOnSeekBarChangeListener(this)
    }


}

