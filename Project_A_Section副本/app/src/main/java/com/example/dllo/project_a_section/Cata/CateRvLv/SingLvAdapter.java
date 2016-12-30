package com.example.dllo.project_a_section.Cata.CateRvLv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.project_a_section.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/11/29.
 */

public class SingLvAdapter extends BaseAdapter {
    List<SingBean.DataBean.CategoriesBean> data;
    private Context context ;
    private int selectIndex;

    public void setData(List<SingBean.DataBean.CategoriesBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public SingLvAdapter(Context context) {
        this.context = context;
    }

    public void setSelectIndex(int selectIndex) {
        this.selectIndex = selectIndex;
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
        MyViewHolder holder = null ;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_lv_sing,viewGroup,false);
            holder = new MyViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (MyViewHolder) view.getTag();
        }
        holder.textView.setText(data.get(i).getName());
        return view;
    }

    public  void setIndex(int index){
        selectIndex = index;
    }


    class MyViewHolder{
         private TextView textView ;
        public MyViewHolder (View view){
            textView = (TextView) view.findViewById(R.id.tv_lv_sing);
        }


    }
}
