package com.dao.practicedraw.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.toast

/**
 * 所有Fragment的基类
 * @author daoz
 * @date :2020/3/18 15:17
 */
abstract class BaseFragment : Fragment() , AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    /*
    * fragment初始化
    * */
    protected fun init() {
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return initView()
    }

    /*
    * 获取布局view
    * */
    abstract fun initView(): View?

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
        initData()
    }

    /*
    * 初始化数据
    * */
    open protected fun initData() {

    }

    /*
    * adapter listener
    * */
    open protected fun initListener() {
    }

    fun myToast(msg:String){
        context?.runOnUiThread { toast(msg) }
    }

    open fun dip2Px(dpValue: Float): Float {
//    val scale = this.context.resources.displayMetrics.density
//    return dpValue * scale
        return Math.round(resources.displayMetrics.density * dpValue).toFloat();
    }
}