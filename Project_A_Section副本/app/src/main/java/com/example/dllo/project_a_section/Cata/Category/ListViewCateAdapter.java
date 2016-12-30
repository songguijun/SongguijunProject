package com.example.dllo.project_a_section.Cata.Category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.dllo.project_a_section.Cata.CateBean;
import com.example.dllo.project_a_section.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/11/29.
 */

public class ListViewCateAdapter extends BaseAdapter {
    private List<CategoryBean.DataBean.ChannelGroupsBean> data;
    private Context context ;


    public void setData(List<CategoryBean.DataBean.ChannelGroupsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public ListViewCateAdapter(Context context) {
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
        MyViewHolder holder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.cate_category_gird,viewGroup,false);
            holder = new MyViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (MyViewHolder) view.getTag();
        }
       holder.textView.setText(data.get(0).getName());
        holder.textViewOne.setText(data.get(0).getName());
        holder.textViewTwo.setText(data.get(0).getName());
        return view;
    }
    class MyViewHolder{
        private TextView textView,textViewOne , textViewTwo;
        public MyViewHolder(View view){
            textView = (TextView) view.findViewById(R.id.tv_category);
            textViewOne = (TextView) view.findViewById(R.id.tv_category_one);
            textViewTwo = (TextView) view.findViewById(R.id.tv_category_two);

        }
    }
}
