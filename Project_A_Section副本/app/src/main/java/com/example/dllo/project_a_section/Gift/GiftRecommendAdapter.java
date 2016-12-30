package com.example.dllo.project_a_section.Gift;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.project_a_section.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dllo on 16/11/25.
 */

public class GiftRecommendAdapter extends RecyclerView.Adapter<GiftRecommendAdapter.MyViewHolder> {
    private ArrayList<GiftRecommentBean>data;
    private Context context ;

    public GiftRecommendAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<GiftRecommentBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(context).inflate(R.layout.recommend_fragment,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
       return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Picasso.with(context).load(data.get(0).getData().getItems().get(position).getCover_image_url()).into(holder.iv_recommend);
        holder.tv_title.setText(data.get(0).getData().getItems().get(position).getShort_description());
        holder.tv_count.setText(data.get(0).getData().getItems().get(position).getName());
        holder.tv_place.setText(data.get(0).getData().getItems().get(position).getPrice());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,GiftActivity.class);
                String num = data.get(0).getData().getItems().get(position).getId() + "";
                intent.putExtra("Key",num);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data  != null && data.size()>0 ? data.get(0).getData().getItems().size():0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_recommend;
        private TextView tv_title,tv_count,tv_place;
        private LinearLayout linearLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.liner);
            iv_recommend = (ImageView) itemView.findViewById(R.id.iv_item_fragment_list);
            tv_title = (TextView) itemView.findViewById(R.id.tv_item_fragment_list_title);
            tv_count = (TextView) itemView.findViewById(R.id.tv_item_fragment_list_msg);
           tv_place = (TextView) itemView.findViewById(R.id.tv_item_fragment_list_money);
        }
    }
}
