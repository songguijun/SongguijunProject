package com.example.dllo.project_a_section.Cata;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.project_a_section.Base.BeasFragment;
import com.example.dllo.project_a_section.Cata.CateRvLv.SingAdapterGird;
import com.example.dllo.project_a_section.Cata.CateRvLv.SingBean;
import com.example.dllo.project_a_section.Cata.CateRvLv.SingLvAdapter;
import com.example.dllo.project_a_section.Cata.CateRvLv.SingRvAdapter;
import com.example.dllo.project_a_section.Cata.Category.CategoryBean;
import com.example.dllo.project_a_section.R;
import com.example.dllo.project_a_section.URLTools;
import com.example.dllo.project_a_section.Volley.NetHelper;
import com.example.dllo.project_a_section.Volley.NetListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by dllo on 16/11/26.
 */

public class CateSingleProductFragment extends BeasFragment {
    private int selectIndex = 0;
    private ListView leftLv, rightLv;
    private SingLvAdapter leftAdapter;
    private SingRvAdapter rightAdapter;
    private List<SingBean.DataBean.CategoriesBean> leftDatas;// 左边的listview
    private List<SingBean.DataBean.CategoriesBean> rightDatas;// 右边的listview
    private List<SingBean.DataBean.CategoriesBean.SubcategoriesBean> gridDatas;

    @Override
    protected int setLayout() {
        return R.layout.cate_sing_product_fragment;
    }

    @Override
    protected void initView(View view) {
        leftLv = (ListView) view.findViewById(R.id.lv_sing);
        rightLv = (ListView) view.findViewById(R.id.lv_sing_one);

    }

    @Override
    public void initData() {
        onItemClick();
        getContent();
    }

    private void onItemClick() {
        leftLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectIndex = i;
                leftAdapter.setSelectIndex(i);
                leftAdapter.notifyDataSetChanged();
                // 当点击某个item的时候让这个item自动滑动到listview的顶部
                // 如果点击的是最后一个就不能到达顶部了
                leftLv.smoothScrollToPositionFromTop(i, 0);
                rightAdapter.setIndex(i);
                rightLv.setSelection(i);
            }
        });
        /**
         *
         *
         * scrollState = SCROLL_STATE_TOUCH_SCROLL(1) 正在滚动
         * scrollState = SCROLL_STATE_FLING(2) 手指做了抛的动作（手指离开屏幕前，用力滑了一下）
         * scrollState = SCROLL_STATE_IDLE(0) 停止滚动
         */
        rightLv.setOnScrollListener(new AbsListView.OnScrollListener() {
            private int scrollState;

            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                this.scrollState = i;
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                // 当用户已经停止滑动了，就不再执行下面的操作
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    return;
                }
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    return;
                }

                //把下标传过去，然后刷新adapter
                leftAdapter.setIndex(i);
                leftLv.smoothScrollToPositionFromTop(i, 0);
                leftLv.setSelection(i);
                leftAdapter.notifyDataSetChanged();

            }
        });
}

        private void getContent() {
         String sing  = URLTools.SING;
        NetHelper.MyRequest(sing, SingBean.class, new NetListener<SingBean>() {
            @Override
            public void successListener(SingBean response) {
                leftDatas = response.getData().getCategories();
                rightDatas = response.getData().getCategories();
                leftAdapter = new SingLvAdapter(getContext());
                leftAdapter.setData(leftDatas);
                leftLv.setAdapter(leftAdapter);
                gridDatas = new ArrayList<>();
                rightAdapter = new SingRvAdapter(getContext());
                rightAdapter.setDatas(rightDatas);
                rightAdapter.setList(gridDatas);
                rightLv.setAdapter(rightAdapter);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });

    }
}