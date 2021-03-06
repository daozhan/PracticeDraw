package com.dao.practicedraw.fragment

import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.AnticipateInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import com.dao.practicedraw.R
import com.dao.practicedraw.base.BaseFragment
import com.dao.practicedraw.widget.DrawArcView
import com.dao.practicedraw.widget.DrawCircleView
import kotlinx.android.synthetic.main.frg_property_animation.*

/**
 * 属性动画
 * @author daoz
 * @date :2020/3/30 10:37
 */
class PropertyAnimationFragment : BaseFragment() {
    override fun initView(): View? {
        return View.inflate(context, R.layout.frg_property_animation, null)

    }

    override fun initListener() {
        super.initListener()
        start.setOnClickListener(View.OnClickListener {
            val animator  = ObjectAnimator.ofFloat(sportsview, "progress", 0f, 65f)
            animator.duration = 5000
            animator.start()
            image.animate().translationX(500f).interpolator = LinearInterpolator()
        })
    }


}