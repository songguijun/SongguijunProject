package com.example.dllo.project_a_section.Banner;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.project_a_section.Base.BaseActivity;
import com.example.dllo.project_a_section.Home.CoolsFragment;
import com.example.dllo.project_a_section.MainActivity;
import com.example.dllo.project_a_section.R;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/6.
 */

public class BannerActivity extends BaseActivity {
    private ImageView imageView;
    private ListView listView;
    private ArrayList<BannerBeanOne> data;

    @Override
    protected int setLayout() {
        return R.layout.banner_activity;
    }

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.banner_lv);
        imageView = (ImageView) findViewById(R.id.banner_iv);
    }

    @Override
    public void initData() {
        data = new ArrayList<>();
        Intent intent = getIntent();
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentOne = new Intent(BannerActivity.this,MainActivity.class);
//                startActivity(intentOne);
//            }
//        });
        String name = intent.getStringExtra("banner");
        String num = "http://api.liwushuo.com/v2/collections/" + name + "/posts?limit=20&offset=0";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(num, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(response, "aaaaa");
                Gson gson = new Gson();
                BannerBeanOne bean = gson.fromJson(response, BannerBeanOne.class);
                data.add(bean);
                BannerAdapter adapter = new BannerAdapter(BannerActivity.this);
                adapter.setData(data);
                listView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);

    }


}

