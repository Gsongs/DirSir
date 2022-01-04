package com.bawei.library_bese;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import java.util.ArrayList;

public
/**
 *作者：王先生
 *时间：2021/12/8 14:40
 *用途：
 */
class MyApater extends FragmentPagerAdapter {
    ArrayList<Fragment> list;
    public MyApater(@NonNull  FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return list.size();
    }


}
