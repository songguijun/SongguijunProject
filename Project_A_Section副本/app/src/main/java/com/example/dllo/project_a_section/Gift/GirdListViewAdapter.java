package com.example.dllo.project_a_section.Gift;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.project_a_section.Banner.BannerBeanOne;
import com.example.dllo.project_a_section.Cata.Category.CategoryBean;
import com.example.dllo.project_a_section.Cata.Category.ListViewCateAdapter;
import com.example.dllo.project_a_section.Gift.Two.BannerGiftBean;
import com.example.dllo.project_a_section.R;

import java.util.List;

/**
 * Created by dllo on 16/12/9.
 */

public class GirdListViewAdapter extends BaseAdapter {
    private List<GiftBeanOne> data;
    private Context context ;

    public void setData(List<GiftBeanOne> data) {
        this.data = data;
    }

    public GirdListViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return data != null && data.size()>0?data.size():0;
    }
    @Override
    public Object getItem(int i) {
        return data != null ?data.get(i):null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       MyViewHolder  holder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.cate_category_gird,viewGroup,false);
            holder = new MyViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (MyViewHolder) view.getTag();
        }


        return view;
    }
    class MyViewHolder{

        public MyViewHolder(View view){


        }
    }
}
