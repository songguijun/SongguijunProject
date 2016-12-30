package com.example.dllo.three;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnItemLongClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LRecyclerView lRecyclerView;
    private MyAdapter adapter;
    private MyBean myBean;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private List<MyBean.FoodsBean>data;
    private int i = 1;
    private String urlImg = "http://image.haha.mx/2014/08/31/middle/1406957_c10eddc0f80e34b482da2e5009377851_1409417785.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Singurl(UrlAll(1));
        initView();
        lRecyclerView.setAdapter(lRecyclerViewAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        lRecyclerView.setLayoutManager(manager);

        View view = LayoutInflater.from(this).inflate(R.layout.item_head,null);
        ImageView img = (ImageView) view.findViewById(R.id.iv);
        Picasso.with(this).load(urlImg).into(img);
        lRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Toast.makeText(MainActivity.this, "短按" + i, Toast.LENGTH_SHORT).show();
            }
        });
        lRecyclerViewAdapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, int i) {
                Toast.makeText(MainActivity.this, "长按" + i, Toast.LENGTH_SHORT).show();
            }
        });
        lRecyclerViewAdapter.addHeaderView(view);



        lRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.Clean();
                Singurl(UrlAll(1));
                lRecyclerView.refreshComplete();
            }
        });
       lRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
           @Override
           public void onLoadMore() {
             Singurl(UrlAll(++i));
           }
       });

    }
    private void initView(){
        lRecyclerView = (LRecyclerView) findViewById(R.id.lr);
        adapter = new MyAdapter(this);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
        data = new ArrayList<>();
    }
    private void Singurl(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson  = new Gson();
                myBean = gson.fromJson(response,MyBean.class);
                data = myBean.getFoods();
                adapter.setData(data);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        requestQueue.add(stringRequest);
    }

    public String UrlAll(int i){
        return  " http:food.boohee.com/fb/v1/foods?kind=group&value=2&order_by=2&page=" + i + "&order_asc=0";
    }
}
