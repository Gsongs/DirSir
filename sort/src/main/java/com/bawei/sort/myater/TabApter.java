package com.bawei.sort.myater;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public
/**
 *作者：王先生
 *时间：2021/12/22 14:04
 *用途：
 */
class TabApter extends FragmentPagerAdapter {
    ArrayList<Fragment> lists;
    ArrayList<String> titles;

    public TabApter(@NonNull @NotNull FragmentManager fm, int b,ArrayList<Fragment> lists, ArrayList<String> titles) {
        super(fm,b);
        this.lists = lists;
        this.titles = titles;
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        return lists.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return lists.size();
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
    }
}
