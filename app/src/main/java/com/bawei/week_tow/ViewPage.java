package com.bawei.week_tow;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bawei.library_mvp.view.BaseActivity;
import com.bawei.week_tow.fragment.Fragment_ones;
import com.bawei.week_tow.fragment.Fragment_threes;
import com.bawei.week_tow.fragment.Fragment_tows;
import com.bawei.week_tow.mydapater.MyApdater;

import java.util.ArrayList;

public
/**
 *作者：王先生
 *时间：2021/12/16 19:04
 *用途：
 */
class ViewPage extends BaseActivity {
    private androidx.viewpager.widget.ViewPager vpers;
    private android.widget.RadioGroup rg;
    private android.widget.RadioButton but1;
    private android.widget.RadioButton but2;
    private android.widget.RadioButton but3;

    @Override
    public int bandLayout() {
        return R.layout.viewpager;
    }

    @Override
    public void initView() {

        vpers = (ViewPager) findViewById(R.id.vpers);
        rg = (RadioGroup) findViewById(R.id.rg);
        but1 = (RadioButton) findViewById(R.id.but1);
        but2 = (RadioButton) findViewById(R.id.but2);
        but3 = (RadioButton) findViewById(R.id.but3);
    }

    @Override
    public void initData() {



        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new Fragment_ones());
        list.add(new Fragment_tows());
        list.add(new Fragment_threes());

        MyApdater apdater = new MyApdater(getSupportFragmentManager(),list);
        vpers.setAdapter(apdater);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.but1:
                        vpers.setCurrentItem(0);
                        break;
                    case R.id.but2:
                        vpers.setCurrentItem(1);
                        break;
                    case R.id.but3:
                        vpers.setCurrentItem(2);
                        break;
                }
            }
        });

        vpers.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                 switch (position){
                     case 0:
                         rg.check(R.id.but1);
                         break;
                     case 1:
                         rg.check(R.id.but2);
                         break;
                     case 2:
                         rg.check(R.id.but3);
                         break;
                 }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
