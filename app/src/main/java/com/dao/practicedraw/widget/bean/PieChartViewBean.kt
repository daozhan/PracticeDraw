package com.dao.practicedraw.widget.bean

/**
 *
 * @author daoz
 * @date :2020/4/11 14:46
 */

class PieChartViewBean(
    var value: Int   //数值
    , var name: String //名字
)
{

    var color: Int = 0   //颜色
    var percentage: Float = 0.toFloat() //百分比
    var angle: Float = 0.toFloat() //角度
}