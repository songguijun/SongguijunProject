package com.example.dllo.project_a_section.Cata.CateRvLv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.project_a_section.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/29.
 */

public class SingRvAdapter  extends RecyclerView.Adapter {
    private ArrayList<SingBean>data;
    private Context context ;
    public static final  int ONE = 0 ;
    public static final int TWO = 1 ;
    private static  final int COUNT = 4;
    public SingRvAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<SingBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return COUNT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType){
            case ONE:
                View viewOne = LayoutInflater.from(context).inflate(R.layout.item_hard_rv_sing,parent,false);
                holder = new MyViewHolder(viewOne);
                break;
            case TWO:
                View viewTwo = LayoutInflater.from(context).inflate(R.layout.item_rv_sing,parent,false);
                holder = new MyViewHolderOne(viewTwo);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
          int type = getItemViewType(position);
        switch (type){
            case ONE:
                MyViewHolder  holderOne = (MyViewHolder) holder;
                holderOne.textViewName.setText(data.get(0).getData().getCategories().get(position).getName());
                break;
            case TWO:
                MyViewHolderOne holderTwo = (MyViewHolderOne) holder;
                holderTwo.textView.setText(data.get(1).getData().getCategories().get(position).getName());
                Picasso.with(context).load(data.get(0).getData().getCategories().get(position).getIcon_url()).into(holderTwo.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return data != null && data.size()>0 ? data.size(): 0;
    }

    class MyViewHolder extends  RecyclerView.ViewHolder{
        private TextView textViewName ;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.tv_rv__hard_sing);
        }
    }
    class MyViewHolderOne extends  RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public MyViewHolderOne(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.item_rv_sing_tv);
            imageView = (ImageView) itemView.findViewById(R.id.item_rv_sing_iv);
        }
    }
}
