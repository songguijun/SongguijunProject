package com.example.dllo.project_a_section.One;

import android.content.Intent;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.project_a_section.Base.BaseActivity;
import com.example.dllo.project_a_section.R;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/8.
 */

public class OneActivity extends BaseActivity {
    private ArrayList<OneBean>data;
    private ListView listView;
    @Override
    protected int setLayout() {
        return R.layout.one_activity;
    }

    @Override
    protected void initView() {

        listView = (ListView) findViewById(R.id.One_lv);
    }

    @Override
   public void initData() {
        data  = new ArrayList<>();
        Intent intent = getIntent();
        String name =  intent.getStringExtra("One");
        String num = "http://api.liwushuo.com/v2/collections/"+name+"/posts?limit=20&offset=0";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(num, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(response, "aaaaa");
                Gson gson = new Gson();
                OneBean bean = gson.fromJson(response, OneBean.class);
                data.add(bean);
                OneAdapter adapter = new OneAdapter(OneActivity.this);
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

