package com.example.dllo.project_a_section.Gift;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/11/24.
 */

public class TabAdapter_Gift extends FragmentPagerAdapter {
    private static List<GiftTabBean.DataBean.RanksBean>data;
    public TabAdapter_Gift(FragmentManager fm) {
        super(fm);
    }

    public void setData(List<GiftTabBean.DataBean.RanksBean> data) {
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return GiftRecommendFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position).getName();
    }
    public static String getMessage(int pos) {
        return data.get(pos).getId()+"";
    }
}
