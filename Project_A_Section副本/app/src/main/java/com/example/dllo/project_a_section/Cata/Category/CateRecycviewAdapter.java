package com.example.dllo.project_a_section.Cata.Category;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.dllo.project_a_section.Cata.CateBean;
import com.example.dllo.project_a_section.Cata.CateRvAdapter;
import com.example.dllo.project_a_section.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/28.
 */

public class CateRecycviewAdapter extends RecyclerView.Adapter{
    private ArrayList<Bean>data;
    private ArrayList<RecyclerView.Adapter>liatdata;
    private Context context;
    private static final int ONE = 1;
    private static  final int TWO = 2 ;
    private static  final int COUNT = 4;
    public CateRecycviewAdapter(Context context) {
        this.context = context;
    }

    public void setLiatdata(ArrayList<RecyclerView.Adapter> liatdata) {
        this.liatdata = liatdata;

    }

    public void setData(ArrayList<Bean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType){
            case ONE:
                View viewone = LayoutInflater.from(context).inflate(R.layout.cata_racycview,parent,false);
                holder = new MyViewHolder(viewone);
                break;
            case TWO:
                View viewtwo = LayoutInflater.from(context).inflate(R.layout.cate_category_gird,parent,false);
                holder = new MyViewHolderOne(viewtwo);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
          int type = getItemViewType(position);
        switch (type){
            case ONE:
                MyViewHolder holderone = (MyViewHolder) holder;
                holderone.recyclerView.setAdapter(liatdata.get(position));
                GridLayoutManager mag = new GridLayoutManager(context,3, LinearLayout.HORIZONTAL,false);
                holderone.recyclerView.setLayoutManager(mag);
               break;
            case TWO:
                MyViewHolderOne holderTwo = (MyViewHolderOne) holder;
                holderTwo.gridView.setAdapter((ListAdapter) liatdata.get(position));
                holderTwo.gridViewOne.setAdapter((ListAdapter) liatdata.get(position));
                holderTwo.gridViewTwo.setAdapter((ListAdapter) liatdata.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return data != null&& data.size()>0?data.size():0;
    }



    class MyViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView recyclerView;
        public MyViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.cata_rv);
        }
    }
    class MyViewHolderOne extends RecyclerView.ViewHolder{
        private GridView gridView,gridViewOne,gridViewTwo;
        public MyViewHolderOne(View itemView) {
            super(itemView);
            gridView = (GridView) itemView.findViewById(R.id.gird);
            gridViewOne = (GridView) itemView.findViewById(R.id.gird_one);
            gridViewTwo = (GridView) itemView.findViewById(R.id.gird_two);
        }
    }
}
