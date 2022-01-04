package com.bawei.library_mvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bawei.library_mvp.prsenter.IPresenter

open abstract
/**
 *作者：王先生
 *时间：2021/12/9 14:27
 *用途：封装fragment基类
 */
class BaseFragment <P: IPresenter> : Fragment(),IFragment{
    protected lateinit var inflate:View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         inflate = inflater.inflate(bandLayout(), container, false)
         return inflate
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        initData()
    }

    override fun <T : View> findViewById(id: Int):T {
        return inflate.findViewById<T>(id)
    }


}