package com.example.dllo.project_a_section.Cata;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.project_a_section.Base.BeasFragment;
import com.example.dllo.project_a_section.Cata.Category.Bean;
import com.example.dllo.project_a_section.Cata.Category.CateRecycviewAdapter;
import com.example.dllo.project_a_section.Cata.Category.CategoryBean;
import com.example.dllo.project_a_section.Cata.Category.CategoryRvAdapter;
import com.example.dllo.project_a_section.R;
import com.example.dllo.project_a_section.URLTools;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/26.
 */

public class CateRaidersFragment extends BeasFragment{
    private ArrayList<CateBean>data;
    private ArrayList<CategoryBean>datas;
    private RecyclerView caterv;
    private ArrayList<Bean>dataOne;
    private ArrayList<RecyclerView.Adapter> listdata;
    private CateRvAdapter cateRvAdapter;
    private CategoryRvAdapter categoryRvAdapter;


    @Override
    protected int setLayout() {
        return R.layout.cate_zhong_rv;
    }

    @Override
    protected void initView(View view) {
        caterv = (RecyclerView) view.findViewById(R.id.cate_zhong_rv);
        CateRecycviewAdapter adapter = new CateRecycviewAdapter(getContext());
        adapter.setData(dataOne);
        caterv.setAdapter(adapter);
        LinearLayoutManager maa = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        caterv.setLayoutManager(maa);
}

    @Override
    public void initData() {
        data = new ArrayList<>();
        datas = new ArrayList<>();
        dataOne = new ArrayList<>();
        CateRecycviewAdapter adapters = new CateRecycviewAdapter(getContext());
        adapters.setData(dataOne);
        caterv.setAdapter(adapters);
        LinearLayoutManager maa = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        caterv.setLayoutManager(maa);
        Result();
        iniCategory();

    }
    public void Result(){
        String url = URLTools.CATERAIDERS;
      //  listdata.add(categoryRvAdapter);
        listdata.add(cateRvAdapter);
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("出来",response);
                Gson gson = new Gson();
                CateBean bean = gson.fromJson(response,CateBean.class);
                data.add(bean);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);

    }
    public void iniCategory (){
        String tom = URLTools.CATEGORY;
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(tom, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("我擦",response);
                Gson gsonone = new Gson();
                CategoryBean beanone =gsonone.fromJson(response,CategoryBean.class);
                datas.add(beanone);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);


    }




}
