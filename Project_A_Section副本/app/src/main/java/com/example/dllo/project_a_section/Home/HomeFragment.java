package com.example.dllo.project_a_section.Home;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.project_a_section.Base.BeasFragment;
import com.example.dllo.project_a_section.Home.Popup.GirdAdapterPop;
import com.example.dllo.project_a_section.R;
import com.example.dllo.project_a_section.TabLayout.MyTableLayoutAdapter;
import com.example.dllo.project_a_section.URLTools;
import com.example.dllo.project_a_section.Volley.NetHelper;
import com.example.dllo.project_a_section.Volley.NetListener;
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
    private ImageView imageView, imageViewOne,ivremind;
    private PopupWindow popupWindow;
    private GirdAdapterPop adapterPop;
    private GridView gridView;
    @Override
    protected int setLayout() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tb_home);
        viewPager = (ViewPager) view.findViewById(R.id.vp_home);
        imageView = (ImageView) view.findViewById(R.id.iv_home_pup);
        ivremind = (ImageView) view.findViewById(R.id.iv_remind);
    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        showPopup();
        initHand();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.showAsDropDown(ivremind);

            }
        });

    }

    public void initHand() {
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


    private void showPopup() {
        popupWindow = new PopupWindow(getContext());
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setTouchable(true);
        final View view1 = LayoutInflater.from(getContext()).inflate(R.layout.pup, null);
        imageViewOne = (ImageView) view1.findViewById(R.id.iv);
        imageViewOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();

            }
        });
        gridView = (GridView) view1.findViewById(R.id.pup_gird);
        popupWindow.setContentView(view1);
        popupWindow.setOutsideTouchable(true);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    viewPager.setCurrentItem(i);

                }
            }

        });


        adapterPop = new GirdAdapterPop(getContext());
        String urlPop = URLTools.TITLE;
        NetHelper.MyRequest(urlPop,TableHomeBean.class, new NetListener<TableHomeBean>() {

            @Override
            public void successListener(TableHomeBean response) {
                adapterPop.setBean(response);
                gridView.setAdapter(adapterPop);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });

    }
}