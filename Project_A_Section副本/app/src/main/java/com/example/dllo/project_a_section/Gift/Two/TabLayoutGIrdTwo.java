package com.example.dllo.project_a_section.Gift.Two;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/9.
 */

public class TabLayoutGIrdTwo extends FragmentPagerAdapter {
    private ArrayList<Fragment>data;
    private String[] title={"单品","精选","评论"};
    public TabLayoutGIrdTwo(FragmentManager fm) {
        super(fm);
    }

    public TabLayoutGIrdTwo(FragmentManager fm, ArrayList<Fragment> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

}
