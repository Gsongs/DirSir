package com.bawei.shop;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.library_bese.RoutePath;
import com.bawei.library_mvp.view.BaseActivity;
import com.blankj.utilcode.util.ToastUtils;

import org.greenrobot.eventbus.EventBus;

public
/**
 *作者：王先生
 *时间：2021/12/19 18:47
 *用途：返回首页
 */
@Route(path = "/s/s")
class Pay_success extends BaseActivity {
    private android.widget.Button fanhui;

    @Override
    public int bandLayout() {
        return R.layout.pay_success;
    }

    @Override
    public void initView() {

        fanhui = (Button) findViewById(R.id.fanhui);
    }

    @Override
    public void initData() {
          fanhui.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  ARouter.getInstance().build("/com/bawei/week_tow/MainActivity").navigation();
              }
          });
    }
}
