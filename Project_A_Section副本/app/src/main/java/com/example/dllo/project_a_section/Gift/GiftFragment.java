package com.example.dllo.project_a_section.Gift;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.project_a_section.Base.BeasFragment;
import com.example.dllo.project_a_section.Home.TableHomeBean;
import com.example.dllo.project_a_section.R;
import com.example.dllo.project_a_section.TabLayout.MyTableLayoutAdapter;
import com.example.dllo.project_a_section.URLTools;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/11/23.
 */

public class GiftFragment extends BeasFragment {

    private List<GiftTabBean.DataBean.RanksBean>data;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected int setLayout() {
        return R.layout.gift_fragment;
    }

    @Override
    protected void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tb_gift);
        viewPager = (ViewPager) view.findViewById(R.id.vp_gift);
    }

    @Override
    public void initData() {
        data  = new ArrayList<>();
        initHand();

    }
    public void  initHand() {
        String tab = URLTools.TABGIRL;
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        StringRequest stringRequest = new StringRequest(tab, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("是是是", response);
                Gson gson = new Gson();
                GiftTabBean beanone = gson.fromJson(response, GiftTabBean.class);
                data = beanone.getData().getRanks();
                TabAdapter_Gift adapter = new TabAdapter_Gift(getChildFragmentManager());
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
