package com.bawei.library_mvp.prsenter

import com.bawei.library_mvp.model.IModel
import com.bawei.library_mvp.view.IView
open abstract
/**
 *作者：王先生
 *时间：2021/12/9 14:27
 *用途：业务处理,内部持有Model和View;使用CallBack获取Model获取结果信息
 */
class BasePresenter <M: IModel,V: IView> : IPresenter{
     var mModel:M
     var mView:V

    constructor(mModel: M, mView: V) {
        this.mModel = mModel
        this.mView = mView
    }

    override fun destroy() {
    }



}