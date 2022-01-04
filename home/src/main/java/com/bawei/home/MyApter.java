package com.bawei.home;

import android.icu.text.CaseMap;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public
/**
 *作者：王先生
 *时间：2021/12/10 15:28
 *用途：
 */
class MyApter extends FragmentPagerAdapter {
    ArrayList<String> strings;

    public MyApter(@NonNull @NotNull FragmentManager fm, ArrayList<String> strings) {
        super(fm);
        this.strings = strings;
    }


    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */


    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return strings.size();
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

}
