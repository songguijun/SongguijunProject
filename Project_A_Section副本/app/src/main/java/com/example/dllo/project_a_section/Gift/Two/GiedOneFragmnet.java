package com.example.dllo.project_a_section.Gift.Two;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.project_a_section.Banner.BannerActivity;
import com.example.dllo.project_a_section.Banner.BannerBean;
import com.example.dllo.project_a_section.Banner.BannerBeanOne;
import com.example.dllo.project_a_section.Banner.MyBanner;
import com.example.dllo.project_a_section.Base.BeasFragment;
import com.example.dllo.project_a_section.Cata.CateBean;
import com.example.dllo.project_a_section.Cata.CateRvAdapter;
import com.example.dllo.project_a_section.Cata.CateRvLv.SingBean;
import com.example.dllo.project_a_section.Cata.CateRvLv.SingLvAdapter;
import com.example.dllo.project_a_section.Cata.CateRvLv.SingRvAdapter;
import com.example.dllo.project_a_section.Gift.GiftBeanOne;
import com.example.dllo.project_a_section.Gift.GiftRecommendAdapter;
import com.example.dllo.project_a_section.Gift.GiftRecommentBean;
import com.example.dllo.project_a_section.Gift.GirdListViewAdapter;
import com.example.dllo.project_a_section.R;
import com.example.dllo.project_a_section.URLTools;
import com.example.dllo.project_a_section.Volley.NetHelper;
import com.example.dllo.project_a_section.Volley.NetListener;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/9.
 */

public class GiedOneFragmnet extends BeasFragment {
    private Banner banner;
    private ArrayList<String>dataBanner;
    private ArrayList<GiftBeanOne>datas;
    private View bannerView;
    private TextView tvOne,tvTwo,tvThree,tvFour,tvFive;
    private RecyclerView recyclerView;
    @Override
    protected int setLayout() {
        return R.layout.item_gift_banner;
    }

    @Override
    protected void initView(View view) {
        bannerView = LayoutInflater.from(getContext()).inflate(R.layout.item_gift_banner, null);

    }



    @Override
    public void initData() {
        dataBanner  = new ArrayList<>();
        datas = new ArrayList<>();
        Intent intent = getActivity().getIntent();
        String name = intent.getStringExtra("Key");
        String ban = "http://api.liwushuo.com/v2/items/"+name;
        banner = (Banner) bannerView.findViewById(R.id.gift_one_banner);
        tvOne = (TextView) bannerView.findViewById(R.id.tv_gift_one);
        tvTwo = (TextView) bannerView.findViewById(R.id.tv_gift_two);
        tvThree = (TextView) bannerView.findViewById(R.id.tv_gift_three);
        tvFour = (TextView) bannerView.findViewById(R.id.tv_gift_four);
        tvFive = (TextView) bannerView.findViewById(R.id.tv_gift_five);
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(ban, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                final BannerGiftBean beanBanner = gson.fromJson(response, BannerGiftBean.class);
                for (int i = 0; i < beanBanner.getData().getImage_urls().size(); i++) {
                    dataBanner.add(beanBanner.getData().getImage_urls().get(i));
                }
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                banner.setImageLoader(new MyBanner());
                banner.setImages(dataBanner);
                banner.setBannerAnimation(Transformer.DepthPage);
                banner.isAutoPlay(true);
                banner.setDelayTime(20000000);
                banner.setIndicatorGravity(BannerConfig.CENTER);
                banner.start();
//                tvOne.setText(beanBanner.getData().getShort_description());
//                tvTwo.setText(beanBanner.getData().getName());
//                tvThree.setText(beanBanner.getData().getPrice());
////               tvFour.setText(beanBanner.getData().getLikes_count());
//                tvFive.setText(beanBanner.getData().getDescription());



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(stringRequest);
        getContent();
    }

    private void getContent() {
        Intent intent = getActivity().getIntent();
        String name = intent.getStringExtra("Key");
        String sing = "http://api.liwushuo.com/v2/items/" + name + "/recommend?num=20&post_num=5";
        final View view = LayoutInflater.from(getContext()).inflate(R.layout.gift_two_rv,null);
        recyclerView = (RecyclerView) view.findViewById(R.id.gift_two_rv);
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(sing, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                GiftBeanOne bean = gson.fromJson(response, GiftBeanOne.class);
                datas.add(bean);
                GiftRecycViewAdapter adapters = new GiftRecycViewAdapter(getContext());
                adapters.setData(datas);
                recyclerView.setAdapter(adapters);
                GridLayoutManager manager = new GridLayoutManager(getContext(),1, LinearLayoutManager.HORIZONTAL,false);
                recyclerView.setLayoutManager(manager);
             }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }


}
