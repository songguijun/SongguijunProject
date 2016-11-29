package com.example.dllo.project_a_section.TabLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.project_a_section.Home.GIrLBean;
import com.example.dllo.project_a_section.Home.GirlAdapter;
import com.example.dllo.project_a_section.R;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/23.
 */

public class HomeSiftFragment extends Fragment {
    private ArrayList<GIrLBean> data;
    private String path;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_girl_liseview, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView) view.findViewById(R.id.lv_girl);


    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        data = new ArrayList<>();
        Bundle bundle = getArguments();
        String mgs = bundle.get("key").toString();
        path = "http://api.liwushuo.com/v2/channels/" +
                mgs + "/items_v2?gender=1&limit=20&offset=0&generation=2";
        Requst();


    }

    public static HomeSiftFragment newInstance(int pos) {
        Bundle args = new Bundle();
        String message = MyTableLayoutAdapter.getMessage(pos);
        args.putString("key",message);
        HomeSiftFragment fragment = new HomeSiftFragment();
        fragment.setArguments(args);
        return fragment;
    }
    private void Requst(){
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("数据",response);
                Gson gson = new Gson();
                GIrLBean bean = gson.fromJson(response,GIrLBean.class);
                GirlAdapter adapter = new GirlAdapter(getContext());
                data.add(bean);
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
