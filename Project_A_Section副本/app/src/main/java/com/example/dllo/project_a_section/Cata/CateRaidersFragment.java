package com.example.dllo.project_a_section.Cata;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.project_a_section.Base.BeasFragment;
import com.example.dllo.project_a_section.Cata.Category.CateGirdAdapter;
import com.example.dllo.project_a_section.Cata.Category.CateGirdOneAdapter;
import com.example.dllo.project_a_section.Cata.Category.CateGirdTwoAdapter;
import com.example.dllo.project_a_section.Cata.Category.CategoryBean;
import com.example.dllo.project_a_section.Cata.Category.ListViewCateAdapter;
import com.example.dllo.project_a_section.R;
import com.example.dllo.project_a_section.URLTools;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/11/26.
 */

public class CateRaidersFragment extends BeasFragment {
    private List<CategoryBean> gird,girdOne,girdTwo;
    private List<CategoryBean.DataBean.ChannelGroupsBean>data;
    private ArrayList<CateBean>datas;
    private RecyclerView recyclerView;
    private GridView gv,gv1,gv2;
    private ListView listView ;
    private CateGirdAdapter girdAdapter;
    private CateGirdOneAdapter girdAdapterOne;
    private CateGirdTwoAdapter girdAdapterTwo;




    @Override
    protected int setLayout() {
        return R.layout.cate_listview ;
    }

    @Override
    protected void initView(View view) {
        listView = (ListView) view.findViewById(R.id.cate_listview);
    }

    @Override
    public void initData() {
    data = new ArrayList<>();
        datas = new ArrayList<>();
        gird = new ArrayList<>();
        girdOne  = new ArrayList<>();
        girdTwo = new ArrayList<>();
        ListViewCateAdapter adapter = new ListViewCateAdapter(getContext());
        adapter.setData(data);
        listView.setAdapter(adapter);
        initHand();
        initHander();
    }
    public void  initHand(){
        String pat = URLTools.RAIDERSTWO;
        final View viewone = LayoutInflater.from(getContext()).inflate(R.layout.cate_category_gird,null);
        gv = (GridView) viewone.findViewById(R.id.gird);
        gv1 = (GridView) viewone.findViewById(R.id.gird_one);
        gv2 = (GridView) viewone.findViewById(R.id.gird_two);
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(pat, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("我是鬼",response);
                Gson gson = new Gson();
                CategoryBean beanOne = gson.fromJson(response, CategoryBean.class);
                girdAdapter =  new CateGirdAdapter(getContext());
                girdAdapterOne = new CateGirdOneAdapter(getContext());
                girdAdapterTwo = new CateGirdTwoAdapter(getContext());
                gv.setAdapter(girdAdapter);
                gv1.setAdapter(girdAdapterOne);
                gv2.setAdapter(girdAdapterTwo);
                girdAdapter.setData(gird);
                girdAdapterOne.setData(girdOne);
                girdAdapterTwo.setData(girdTwo);
                gird.add(beanOne);
                girdOne.add(beanOne);
                girdTwo.add(beanOne);
                listView.addFooterView(viewone);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);

    }
    public void  initHander(){
        String num = URLTools.RAIDERSONE;
        final View view = LayoutInflater.from(getContext()).inflate(R.layout.cata_racycview,null);
        recyclerView = (RecyclerView) view.findViewById(R.id.cata_rv);
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(num, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("我是鬼",response);
                Gson gson = new Gson();
                CateBean bean = gson.fromJson(response, CateBean.class);
                datas.add(bean);
                CateRvAdapter adapters = new CateRvAdapter(getActivity());
                adapters.setDatacata(datas);
                recyclerView.setAdapter(adapters);
                GridLayoutManager manager = new GridLayoutManager(getContext(),3, LinearLayoutManager.HORIZONTAL,false);
                recyclerView.setLayoutManager(manager);
                listView.addHeaderView(view);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);

    }

}
