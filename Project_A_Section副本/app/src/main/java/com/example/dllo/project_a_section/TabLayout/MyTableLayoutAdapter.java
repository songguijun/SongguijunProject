package com.example.dllo.project_a_section.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dllo.project_a_section.Home.CoolsFragment;
import com.example.dllo.project_a_section.Home.TableHomeBean;

import java.util.List;

/**
 * Created by dllo on 16/11/23.
 */

public class MyTableLayoutAdapter extends FragmentPagerAdapter {
    private static List<TableHomeBean.DataBean.ChannelsBean> data;
    public MyTableLayoutAdapter(FragmentManager fm) {
        super(fm);
    }


    public void setData(List<TableHomeBean.DataBean.ChannelsBean> data) {
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new CoolsFragment();
        }else {
            return HomeSiftFragment.newInstance(position);

        }
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
