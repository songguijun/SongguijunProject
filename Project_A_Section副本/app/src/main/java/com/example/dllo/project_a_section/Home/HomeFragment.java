package com.example.dllo.project_a_section.Home;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.project_a_section.Base.BeasFragment;
import com.example.dllo.project_a_section.R;
import com.example.dllo.project_a_section.TabLayout.MyTableLayoutAdapter;
import com.example.dllo.project_a_section.URLTools;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/11/23.
 */

public class HomeFragment extends BeasFragment {
     private List<TableHomeBean.DataBean.ChannelsBean> data;
     private TabLayout tabLayout;
     private ViewPager viewPager;
     private ImageView imageView;

    @Override
    protected int setLayout() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tb_home);
        viewPager = (ViewPager) view.findViewById(R.id.vp_home);
        imageView = (ImageView) view.findViewById(R.id.iv_home_pup);
    }

    @Override
    public void initData() {
        data  = new ArrayList<>();
        initHand();


    }
    public void  initHand() {
        String rem = URLTools.TITLE;
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        StringRequest stringRequest = new StringRequest(rem, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("是是是", response);
                Gson gson = new Gson();
                TableHomeBean beanone = gson.fromJson(response, TableHomeBean.class);
                data = beanone.getData().getChannels();
                MyTableLayoutAdapter adapter = new MyTableLayoutAdapter(getChildFragmentManager());
                adapter.setData(data);
                viewPager.setAdapter(adapter);
                tabLayout.setupWithViewPager(viewPager);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);

    }
}

