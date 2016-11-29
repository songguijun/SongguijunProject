package com.example.dllo.project_a_section.Cata;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.project_a_section.Cata.Category.Bean;
import com.example.dllo.project_a_section.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/28.
 */

public class CateRvAdapter extends RecyclerView.Adapter<CateRvAdapter.MyViewHolder> {
    private ArrayList<CateBean>datacata;
    private Context mContext;

    public CateRvAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setDatacata(ArrayList<CateBean> datacata) {
        this.datacata = datacata;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cate_raiders_fragment,null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_title.setText(datacata.get(0).getData().getColumns().get(position).getTitle());
        holder.tv_name.setText(datacata.get(0).getData().getColumns().get(position).getAuthor());
        Picasso.with(mContext).load(datacata.get(0).getData().getColumns().get(position).getCover_image_url()).into(holder.iv);

    }

    @Override
    public int getItemCount() {
        return datacata != null && datacata.size()>0 ? datacata.get(0).getData().getColumns().size():0;
    }



    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv ;
        private TextView tv_title , tv_name;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_raiders);
            tv_title = (TextView) itemView.findViewById(R.id.tv_raiders_title);
            tv_name = (TextView) itemView.findViewById(R.id.tv_raiders_name);
        }
    }
}
