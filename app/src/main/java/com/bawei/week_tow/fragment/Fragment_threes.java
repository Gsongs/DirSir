package com.bawei.week_tow.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.bawei.library_mvp.view.BaseFragment;
import com.bawei.week_tow.MainActivity;
import com.bawei.week_tow.R;

public
/**
 *作者：王先生
 *时间：2021/12/9 10:58
 *用途：
 */
class Fragment_threes extends BaseFragment {


    private Button tiaozhuan;

    @Override
    public int bandLayout() {
        return R.layout.fragment_three;
    }

    @Override
    public void initView() {


        tiaozhuan = (Button) findViewById(R.id.tiaozhuan);
    }

    @Override
    public void initData() {
        tiaozhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
