package com.bawei.library_mvp.view

import androidx.annotation.LayoutRes

/**
 *作者：王先生
 *时间：2021/12/9 14:27
 *用途：
 */
interface IActivity {
    @LayoutRes
    fun bandLayout():Int //布局资源

    fun initView()  //初始化控件

    fun initData() //初始化数据

}