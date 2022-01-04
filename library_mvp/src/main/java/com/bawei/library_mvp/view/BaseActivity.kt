package com.bawei.library_mvp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bawei.library_mvp.prsenter.IPresenter

 abstract
/**
 *作者：王先生
 *时间：2021/12/9 14:27
 *用途：对于View层也是视图层，在View层中只负责对数据的展示，提供友好的界面与用户进行交互
 */
class BaseActivity <P: IPresenter>   : AppCompatActivity(),IActivity{

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(bandLayout())
         initView()
         initData()
     }
}