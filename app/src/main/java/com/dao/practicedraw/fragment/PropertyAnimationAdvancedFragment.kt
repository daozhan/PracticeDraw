package com.dao.practicedraw.fragment

import android.animation.*
import android.view.View
import android.view.animation.*
import com.dao.practicedraw.R
import com.dao.practicedraw.base.BaseFragment
import com.dao.practicedraw.widget.DrawArcView
import com.dao.practicedraw.widget.DrawCircleView
import kotlinx.android.synthetic.main.frg_property_animation.*
import kotlinx.android.synthetic.main.frg_property_animation.start
import kotlinx.android.synthetic.main.frg_property_animation_advanced.*
import java.net.PortUnreachableException
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import com.dao.practicedraw.R.id.*
import kotlinx.android.synthetic.main.frg_property_animation.sportsview as sportsview1


/**
 * 属性动画
 * @author daoz
 * @date :2020/3/30 10:37
 */
class PropertyAnimationAdvancedFragment : BaseFragment() {
    override fun initView(): View? {
        return View.inflate(context, R.layout.frg_property_animation_advanced, null)

    }

    override fun initListener() {
        super.initListener()
        start.setOnClickListener(View.OnClickListener {
            val animator = ObjectAnimator.ofInt(sphereview, "color", 0xffff0000.toInt(), 0xff00ff00.toInt())
            animator.setEvaluator(ArgbEvaluator())
            animator.duration = 5000
            animator.start()

            val holder1 = PropertyValuesHolder.ofFloat("scaleX", 1f)
            val holder2 = PropertyValuesHolder.ofFloat("scaleY", 1f)
            val holder3 = PropertyValuesHolder.ofFloat("alpha", 1f)

            val animator2 = ObjectAnimator.ofPropertyValuesHolder(sphereview2, holder1, holder2, holder3)
            animator2.duration = 5000
            animator2.start()

            val animator3 = ObjectAnimator.ofFloat(sphereview3, "scaleX", 1f)
            val animator4 = ObjectAnimator.ofFloat(sphereview3, "scaleY", 1f)
            val animator5 = ObjectAnimator.ofFloat(sphereview3, "alpha", 1f)
            val animator6 = ObjectAnimator.ofFloat(sphereview3, "translationX", 200f)

            val animatorSet = AnimatorSet()
            animatorSet.play(animator3).with(animator4).with(animator5).before(animator6)
//            animatorSet.playSequentially(animator3, animator4, animator5,animator6);
            animatorSet.start();

            // 在 0% 处开始
            val keyframe1 = Keyframe.ofFloat(0f, 0f)
            // 时间经过 50% 的时候，动画完成度 100%
            val keyframe2 = Keyframe.ofFloat(0.5f, 100f)
            // 时间见过 100% 的时候，动画完成度倒退到 80%，即反弹 20%
            val keyframe3 = Keyframe.ofFloat(1f, 80f)
            val holder = PropertyValuesHolder.ofKeyframe("progress", keyframe1,
                keyframe2, keyframe3)
            val animator7 = ObjectAnimator.ofPropertyValuesHolder(sportsview, holder)
            animator7.duration = 5000
            animator7.start()
        })
    }


}