package com.example.dllo.project_a_section.Home;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.project_a_section.Banner.BannerBean;
import com.example.dllo.project_a_section.Banner.MyBanner;
import com.example.dllo.project_a_section.Base.BeasFragment;
import com.example.dllo.project_a_section.Home.CardView.GardVIewBean;
import com.example.dllo.project_a_section.Home.CardView.GardViewAdapter;

import com.example.dllo.project_a_section.R;
import com.example.dllo.project_a_section.URLTools;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dllo on 16/11/24.
 */

public class CoolsFragment extends BeasFragment {
    private ArrayList<ListViewHomeBean> data;
    private ListView listView;
    private ArrayList<GardVIewBean> datas;
    private GridView gv;
    private Banner banner;
    private ArrayList<String>dataBanner;
    @Override
    protected int setLayout() {
        return R.layout.item_listview_home;


    }

    @Override
    protected void initView(View view) {
        data = new ArrayList<>();
        datas = new ArrayList<>();
        dataBanner = new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.lv_home);
    }

    @Override
    public void initData() {
        initBanner();
        initHand();

            String url = URLTools.One;
            RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
            StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Gson gson = new Gson();
                    ListViewHomeBean bean = gson.fromJson(response, ListViewHomeBean.class);
                    data.add(bean);
                    MyListViewAdapter adapter = new MyListViewAdapter(getActivity());
                    adapter.setData(data);
                    listView.setAdapter(adapter);
                  //  listView.addHeaderView(gv);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            requestQueue.add(stringRequest);

        }
    public void initBanner(){
        String ban = URLTools.BANNER;
        final View bannerView = LayoutInflater.from(getContext()).inflate(R.layout.gift_gour_fragment,null);
        banner = (Banner) bannerView.findViewById(R.id.carousel_banner);
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(ban, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                BannerBean beanBanner = gson.fromJson(response, BannerBean.class);
                for (int i = 0; i < beanBanner.getData().getBanners().size(); i++) {
                    dataBanner.add(beanBanner.getData().getBanners().get(i).getImage_url());
                }
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                banner.setImageLoader(new MyBanner());
                banner.setImages(dataBanner);
                banner.setBannerAnimation(Transformer.DepthPage);
                banner.isAutoPlay(true);
                banner.setDelayTime(2000);
                banner.setIndicatorGravity(BannerConfig.CENTER);
                banner.start();
                listView.addHeaderView(bannerView);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }
    public void  initHand(){
       String pat = URLTools.GARD;
        final View handView = LayoutInflater.from(getContext()).inflate(R.layout.item_home,null);
        gv = (GridView) handView.findViewById(R.id.home_head_gv);
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(pat, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                GardVIewBean beanone = gson.fromJson(response, GardVIewBean.class);
                datas.add(beanone);
                GardViewAdapter adaptergard = new GardViewAdapter(getActivity());
                adaptergard.setData(datas);
                gv.setAdapter(adaptergard);
                listView.addHeaderView(handView);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);

    }



    }




