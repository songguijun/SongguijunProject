package com.example.dllo.ceshi;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener
{

    private static final int REFRESH_COMPLETE = 0X110;
    private SwipeRefreshLayout mSwipeLayout;
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private List<String> mDatas = new ArrayList<String>(Arrays.asList("Java", "Javascript", "C++", "Ruby", "Json",
            "HTML"));

    private Handler mHandler =  new Handler()
    {
        public void handleMessage(android.os.Message msg)
        {
            switch (msg.what)
            {
                case REFRESH_COMPLETE:

                    mDatas.addAll(Arrays.asList("Lucene", "Canvas", "Bitmap"));
                    mAdapter.notifyDataSetChanged();
                    mSwipeLayout.setRefreshing(false);
                    break;

            }
        };
    };

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.id_listview);
        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.id_swipe_ly);

        mSwipeLayout.setOnRefreshListener(this);
        mSwipeLayout.setColorSchemeColors(Color.BLUE, Color.GREEN,
               Color.DKGRAY, Color.GRAY);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simpel_list_item_1, mDatas);
        mListView.setAdapter(mAdapter);

    }

    public void onRefresh()
    {
        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 2000);
    }
}

