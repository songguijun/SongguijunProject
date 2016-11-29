package com.example.dllo.project_a_section.Cata;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/26.
 */

public class TabCataAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> data;
    private String [ ] title = {"攻略","单品"};
    public TabCataAdapter(FragmentManager fm) {
        super(fm);
    }

    public TabCataAdapter(FragmentManager fm, ArrayList<Fragment> data) {
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

