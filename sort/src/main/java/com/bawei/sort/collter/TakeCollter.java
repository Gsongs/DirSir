package com.bawei.sort.collter;

import com.bawei.library_mvp.model.IModel;
import com.bawei.library_mvp.view.IView;
import com.bawei.sort.callback.MsgCallBack;
import com.bawei.sort.callback.TakeCallBack;
import com.bawei.sort.json.MsgBean;
import com.bawei.sort.json.TakeBean;

import java.util.List;

import io.reactivex.Observer;

public
/**
 *作者：王先生
 *时间：2021/12/13 11:28
 *用途：
 */
interface TakeCollter {
    interface TakeModel extends IModel {
        void TakeModels(Observer<TakeBean> observer);
    }

    interface TakeView extends IView {
        void TakeViews(TakeBean takeBean);
    }
}
