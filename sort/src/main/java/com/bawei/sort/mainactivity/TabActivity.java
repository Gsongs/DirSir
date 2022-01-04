package com.bawei.sort.mainactivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.library_mvp.view.BaseActivity;
import com.bawei.sort.R;
import com.bawei.sort.fragment.Tab_five;
import com.bawei.sort.fragment.Tab_for;
import com.bawei.sort.fragment.Tab_one;
import com.bawei.sort.fragment.Tab_three;
import com.bawei.sort.fragment.Tab_tow;
import com.bawei.sort.myater.TabApter;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public
/**
 *作者：王先生
 *时间：2021/12/22 14:01
 *用途：
 */
class TabActivity extends BaseActivity {
    private com.flyco.tablayout.SlidingTabLayout slidinglab;
    private androidx.viewpager.widget.ViewPager vper;

    @Override
    public int bandLayout() {
        return R.layout.tabactivity;
    }

    @Override
    public void initView() {

        slidinglab = (SlidingTabLayout) findViewById(R.id.slidinglab);
        vper = (ViewPager) findViewById(R.id.vper);
    }

    @Override
    public void initData() {
        ArrayList<Fragment> lists = new ArrayList<>();
        lists.add(new Tab_one());
        lists.add(new Tab_tow());
        lists.add(new Tab_three());
        lists.add(new Tab_for());
        lists.add(new Tab_five());

        ArrayList<String> titles = new ArrayList<>();
        titles.add("待收货");
        titles.add("待付款");
        titles.add("已完成");
        titles.add("待评价");
        titles.add("全部");

        TabApter tabApter = new TabApter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,lists,titles);
        vper.setAdapter(tabApter);
        slidinglab.setViewPager(vper);

    }
}
