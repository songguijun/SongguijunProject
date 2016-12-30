package com.example.dllo.project_a_section.Gift.Two;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.project_a_section.Gift.GiftActivity;
import com.example.dllo.project_a_section.Gift.GiftBeanOne;
import com.example.dllo.project_a_section.Gift.GiftRecommendAdapter;
import com.example.dllo.project_a_section.Gift.GiftRecommentBean;
import com.example.dllo.project_a_section.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/10.
 */

public class GiftRecycViewAdapter extends RecyclerView.Adapter<GiftRecycViewAdapter.MyViewHolder> {
    private ArrayList<GiftBeanOne> data;
    private Context context ;


    public GiftRecycViewAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<GiftBeanOne> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gift_iv,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.with(context).load(data.get(0).getData().getRecommend_items().get(position).getCover_image_url()).into(holder.iv);
    }


    @Override
    public int getItemCount() {
        return data  != null && data.size()>0 ? data.size():0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_gift_two);
        }
    }
}
