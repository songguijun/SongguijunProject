package com.example.dllo.project_a_section.Home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.project_a_section.Home.ListViewHomeBean;
import com.example.dllo.project_a_section.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/23.
 */

public class MyListViewAdapter extends BaseAdapter {
    private ArrayList<ListViewHomeBean>data;
    private Context context ;

    public MyListViewAdapter(Context context) {
        this.context = context;
    }

    public MyListViewAdapter setData(ArrayList<ListViewHomeBean> data) {
        this.data = data;
        notifyDataSetChanged();
        return this;
    }


    @Override
    public int getCount() {
        return data.get(0).getData().getItems().size();
    }

    @Override
    public Object getItem(int i) {
        return data != null ? data.get(0).getData().getItems().get(i):null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder holder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.home_one_fragment,viewGroup,false);
            holder = new MyViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (MyViewHolder) view.getTag();
        }
        if (data.get(0).getData().getItems().get(i).getAd_type() != 1) {
            holder.textView_title.setText(data.get(0).getData().getItems().get(i).getAuthor().getNickname());
            holder.textView_low_title.setText(data.get(0).getData().getItems().get(i).getAuthor().getIntroduction());
            holder.textView_Article.setText(data.get(0).getData().getItems().get(i).getTitle());
            holder.textView_opuscule.setText(data.get(0).getData().getItems().get(i).getIntroduction());
        //    holder.textView_hart.setText(data.get(0).getData().getItems().get(i).getLikes_count());
//            holder.textView_column.setText(data.get(0).getData().getItems().get(i).getColumn().getTitle());
            Picasso.with(context).load(data.get(0).getData().getItems().get(i).getCover_image_url()).into(holder.imageView_pager);
            Picasso.with(context).load(data.get(0).getData().getItems().get(i).getAuthor().getAvatar_url()).into(holder.imageView_Head_portrait);
        }
        return view;
    }


    class MyViewHolder {
        private TextView textView_title , textView_low_title,textView_Article,textView_opuscule,textView_column,textView_hart;
        private ImageView imageView_Head_portrait,imageView_pager;
        public MyViewHolder (View view){
            textView_title = (TextView) view.findViewById(R.id.tv_home_title);
            textView_low_title = (TextView) view.findViewById(R.id.tv_home_one_low_title);
            textView_Article = (TextView) view.findViewById(R.id.tv_home_Article);
            textView_opuscule = (TextView) view.findViewById(R.id.tv_home_opuscule);
            textView_column = (TextView) view.findViewById(R.id.tv_home_column);
            textView_hart = (TextView) view.findViewById(R.id.tv_hard);
            imageView_Head_portrait = (ImageView) view.findViewById(R.id.iv_home_Head_portrait);
            imageView_pager = (ImageView) view.findViewById(R.id.iv_home_pager);
        }
    }
}
