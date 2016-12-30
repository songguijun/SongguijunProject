package com.example.dllo.project_a_section.Home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.project_a_section.Banner.BannerActivity;
import com.example.dllo.project_a_section.Banner.BannerBean;
import com.example.dllo.project_a_section.Banner.MyBanner;
import com.example.dllo.project_a_section.Base.BeasFragment;
import com.example.dllo.project_a_section.Home.CardView.GardVIewBean;
import com.example.dllo.project_a_section.Home.CardView.GardViewAdapter;

import com.example.dllo.project_a_section.Home_WebVIew;
import com.example.dllo.project_a_section.MainActivity;
import com.example.dllo.project_a_section.One.OneActivity;
import com.example.dllo.project_a_section.R;
import com.example.dllo.project_a_section.URLTools;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by dllo on 16/11/24.
 */

public class CoolsFragment extends BeasFragment implements SwipeRefreshLayout.OnRefreshListener{
    private ArrayList<ListViewHomeBean> data;
    private static final int REFRESH_COMPLETE = 0X110;
    private ListView listView;
    private ArrayList<GardVIewBean> datas;
    private GridView gv;
    private Banner banner;
    private MyListViewAdapter adapter;
    private ArrayList<String> dataBanner;
    private SwipeRefreshLayout sr;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case REFRESH_COMPLETE:
                   Intent intent = new Intent(getContext(),MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    sr.setRefreshing(false);
                    break;

            }
        }


    };

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
        sr = (SwipeRefreshLayout) view.findViewById(R.id.srl);
    }
    @Override
    public void initData() {
        initBanner();
        initHand();
        sr.setOnRefreshListener(this);
        sr.setColorSchemeColors(Color.BLUE, Color.GREEN,
                Color.DKGRAY, Color.GRAY);
        String url = URLTools.One;
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(final String response) {
                Gson gson = new Gson();
                final ListViewHomeBean bean = gson.fromJson(response, ListViewHomeBean.class);
                data.add(bean);
                 adapter = new MyListViewAdapter(getActivity());
                adapter.setData(data);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intentWB = new Intent(getContext(),Home_WebVIew.class);
                        String WB = bean.getData().getItems().get(i - 2).getId() + "" ;
                        intentWB.putExtra("Key",WB);
                        startActivity(intentWB);
                    }
                });
                //  listView.addHeaderView(gv);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);

    }

    public void initBanner() {
        String ban = URLTools.BANNER;
        final View bannerView = LayoutInflater.from(getContext()).inflate(R.layout.gift_gour_fragment, null);
        banner = (Banner) bannerView.findViewById(R.id.carousel_banner);
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(ban, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                final BannerBean beanBanner = gson.fromJson(response, BannerBean.class);
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
                banner.setOnBannerClickListener(new OnBannerClickListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        Intent intent = new Intent(getContext(), BannerActivity.class);
                         String bannerId = beanBanner.getData().getBanners().get(position - 1).getTarget_id() + "";
                        intent.putExtra("banner", bannerId);
                        startActivity(intent);
                    }
                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(stringRequest);
    }

    public void initHand() {
        String pat = URLTools.GARD;
        final View handView = LayoutInflater.from(getContext()).inflate(R.layout.item_home, null);
        gv = (GridView) handView.findViewById(R.id.home_head_gv);
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(pat, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                final GardVIewBean beanone = gson.fromJson(response, GardVIewBean.class);
                datas.add(beanone);
                GardViewAdapter adapterGard = new GardViewAdapter(getActivity());
                adapterGard.setData(datas);
                gv.setAdapter(adapterGard);
                gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intentGv =  new Intent(getContext(), OneActivity.class);
                       String OneGv = beanone.getData().getSecondary_banners().get(i - 1).getId() + "";
                        intentGv.putExtra("One",OneGv);
                        startActivity(intentGv);
                    }
                });
                listView.addHeaderView(handView);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(stringRequest);
    }
    @Override
    public void onRefresh() {
        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 2000);
    }
}




