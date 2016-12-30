package com.example.dllo.project_a_section.Cata.Category;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.dllo.project_a_section.Cata.CateBean;
import com.example.dllo.project_a_section.Cata.CateRvAdapter;
import com.example.dllo.project_a_section.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dllo on 16/11/28.
 */

public class CateGirdAdapter extends BaseAdapter{
    private List<CategoryBean> data;
    private Context context ;


    public void setData(List<CategoryBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public CateGirdAdapter(Context context) {
        this.context = context;
    }



    @Override
    public int getCount() {
        return data == null ? 0:6;
    }

    @Override
    public Object getItem(int i) {
        return data != null ? data.get(i):null ;
    }
    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder holder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.cate_image,viewGroup,false);
            holder = new MyViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (MyViewHolder) view.getTag();
        }
        Picasso.with(context).load(data.get(0).getData().getChannel_groups().get(0).getChannels().get(i).getCover_image_url()).into(holder.imageView);
        return view;



    }

    class MyViewHolder {
        private ImageView imageView;
        public MyViewHolder (View view){
            imageView = (ImageView) view.findViewById(R.id.cate_iv);

        }

    }

}
