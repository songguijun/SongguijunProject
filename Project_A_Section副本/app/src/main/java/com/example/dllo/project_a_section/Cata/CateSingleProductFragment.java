package com.example.dllo.project_a_section.Cata;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import com.example.dllo.project_a_section.Base.BeasFragment;
import com.example.dllo.project_a_section.Cata.CateRvLv.SingBean;
import com.example.dllo.project_a_section.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/26.
 */

public class CateSingleProductFragment extends BeasFragment {
    private RecyclerView recyclerView;
    private ListView listView;
    private ArrayList<SingBean>data;
    @Override
    protected int setLayout() {
        return R.layout.cate_sing_product_fragment;
    }

    @Override
    protected void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_sing);
        listView = (ListView) view.findViewById(R.id.lv_sing);
    }

    @Override
    public void initData() {
     data = new ArrayList<>();
    }
}
