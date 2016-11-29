package com.example.dllo.project_a_section.Home.CardView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.project_a_section.Home.ListViewHomeBean;
import com.example.dllo.project_a_section.Home.MyListViewAdapter;
import com.example.dllo.project_a_section.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/25.
 */

public class GardViewAdapter extends BaseAdapter {
    private ArrayList<GardVIewBean>data;
    private Context context ;

    public GardViewAdapter(Context context) {
        this.context = context;
    }


    public void setData(ArrayList<GardVIewBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.get(0).getData().getSecondary_banners().size();
    }

    @Override
    public Object getItem(int i) {
        return data != null ? data.get(0).getData().getSecondary_banners():null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
         MyViewHolder holder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.gardview_home,viewGroup,false);
            holder = new MyViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (MyViewHolder) view.getTag();
        }
        Picasso.with(context).load(data.get(0).getData().getSecondary_banners().get(i).getImage_url()).into(holder.imageView);
        return view;
    }


    class MyViewHolder {
        private ImageView imageView;
        public MyViewHolder (View view){
            imageView = (ImageView) view.findViewById(R.id.iv_gridview);
        }
    }



    }
