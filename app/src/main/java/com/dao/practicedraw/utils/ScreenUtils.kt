package com.dao.practicedraw.utils

import android.view.View

/**
 *
 * @author daoz
 * @date :2020/4/11 11:14
 */

fun View.dip2Px(dpValue: Float): Float {
    val scale = this.context.resources.displayMetrics.density
    return dpValue * scale + 0.5f
}