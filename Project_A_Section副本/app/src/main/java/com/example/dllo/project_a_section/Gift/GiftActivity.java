package com.example.dllo.project_a_section.Gift;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TableLayout;

import com.example.dllo.project_a_section.Base.BaseActivity;
import com.example.dllo.project_a_section.Gift.Two.GiedOneFragmnet;
import com.example.dllo.project_a_section.Gift.Two.GiedThreeFragmnet;
import com.example.dllo.project_a_section.Gift.Two.GiedTwoFragmnet;
import com.example.dllo.project_a_section.Gift.Two.TabLayoutGIrdTwo;
import com.example.dllo.project_a_section.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/9.
 */

public class GiftActivity extends BaseActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment>data;
    @Override
    protected int setLayout() {
        return R.layout.activity_gift;
    }

    @Override
    protected void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tb_gird_two);
        viewPager = (ViewPager) findViewById(R.id.vp_gird_two);

    }

    @Override
    public void initData() {
          data = new ArrayList<>();
        data.add(new GiedOneFragmnet());
        data.add(new GiedTwoFragmnet());
        data.add(new GiedThreeFragmnet());
        TabLayoutGIrdTwo adapter = new TabLayoutGIrdTwo(getSupportFragmentManager(),data);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
