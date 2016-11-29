package com.example.dllo.project_a_section.Gift;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.example.dllo.project_a_section.Base.BeasFragment;
import com.example.dllo.project_a_section.Home.CardView.GardVIewBean;
import com.example.dllo.project_a_section.Home.CardView.GardViewAdapter;
import com.example.dllo.project_a_section.Home.ListViewHomeBean;
import com.example.dllo.project_a_section.Home.MyListViewAdapter;
import com.example.dllo.project_a_section.R;
import com.example.dllo.project_a_section.URLTools;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/24.
 */

public class GiftRecommendFragment extends BeasFragment {
    private ArrayList<GiftRecommentBean>data;
    private RecyclerView recyclerView;
    private String rem;


    @Override
    protected int setLayout() {
        return R.layout.gift_recomment_recycview;
    }

    @Override
    protected void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.gift_recommend_rv);

    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        Bundle mBundle = getArguments();
        String mgs = mBundle.get("key").toString();
        rem = "http://api.liwushuo.com/v2/ranks_v3/ranks/"+mgs+"?limit=20&offset=0";
        Result();
    }
    public static GiftRecommendFragment newInstance(int pos){
        Bundle bundle = new Bundle();
        String massage = TabAdapter_Gift.getMessage(pos);
        bundle.putString("key",massage);
        GiftRecommendFragment fragment = new GiftRecommendFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    public void Result(){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(rem, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                GiftRecommentBean bean = gson.fromJson(response, GiftRecommentBean.class);
                data.add(bean);
                GiftRecommendAdapter adapter = new GiftRecommendAdapter(getContext());
                adapter.setData(data);
                recyclerView.setAdapter(adapter);
                GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
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
