package com.bawei.mine;

import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bawei.library_bese.RoutePath;
import com.bawei.library_mvp.view.BaseFragment;
import com.bawei.mine.fragment.Fragment_Electrical;
import com.bawei.mine.fragment.Fragment_Furniture;
import com.bawei.mine.fragment.Fragment_Gift;
import com.bawei.mine.fragment.Fragment_bus;
import com.bawei.mine.fragment.Fragment_shop;
import com.bawei.mine.fragment.Fragment_toy;
import com.bawei.mine.fragment.Fragment_trip;
import com.bawei.mine.fragment.Fragment_woman;
import com.bawei.mine.fragment.Fragment_computer;
import com.bawei.mine.fragment.Fragment_food;
import com.bawei.mine.fragment.Fragment_Drinks;
import com.bawei.mine.fragment.Fragment_man;
import com.bawei.mine.fragment.Fragment_tel;
import com.chaychan.library.BottomBarItem;
import com.chaychan.library.BottomBarLayout;

import java.util.ArrayList;

@Route(path = RoutePath.MINE_PATH)
public class MineActivity extends BaseFragment {


    private BottomBarLayout bottonlayout;
    private LinearLayout labs;

    @Override
    public int bandLayout() {
        return R.layout.activity_mine;
    }

    @Override
    public void initView() {

        bottonlayout = (BottomBarLayout) findViewById(R.id.bottonlayout);
        labs = (LinearLayout) findViewById(R.id.labs);
    }

    @Override
    public void initData() {
        //把fragment放到一个集合里
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new Fragment_computer());
        list.add(new Fragment_tel());
        list.add(new Fragment_man());
        list.add(new Fragment_woman());
        list.add(new Fragment_Electrical());
        list.add(new Fragment_food());
        list.add(new Fragment_Drinks());

        list.add(new Fragment_toy());
        list.add(new Fragment_bus());
        list.add(new Fragment_Furniture());
        list.add(new Fragment_Gift());
        list.add(new Fragment_trip());
        list.add(new Fragment_shop());


        getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.labs,list.get(0))
                .commit();

        //显示隐藏
        bottonlayout.setOnItemSelectedListener(new BottomBarLayout.OnItemSelectedListener() {
            @Override
            public void onItemSelected(BottomBarItem bottomBarItem, int previousPosition, int currentPosition) {
                if (previousPosition==0&&previousPosition==currentPosition&&!list.get(currentPosition).isAdded()){
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .add(R.id.labs,list.get(currentPosition))
                            .commit();
                }
                if (previousPosition!=currentPosition&&!list.get(currentPosition).isAdded()){
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .hide(list.get(previousPosition))
                            .add(R.id.labs,list.get(currentPosition))
                            .commit();
                }
                if (previousPosition!=currentPosition){
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .hide(list.get(previousPosition))
                            .show(list.get(currentPosition))
                            .commit();
                }
            }
        });

    }


}