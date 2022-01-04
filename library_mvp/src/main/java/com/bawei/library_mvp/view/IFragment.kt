package com.bawei.library_mvp.view

import android.view.View
import androidx.annotation.IdRes

/**
 *作者：王先生
 *时间：2021/12/9 14:27
 *用途：
 */
interface IFragment :IActivity {

    fun <T : View> findViewById(@IdRes  id : Int):T

}