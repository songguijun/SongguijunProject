package com.example.dllo.project_a_section.One;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.project_a_section.Banner.BannerAdapter;
import com.example.dllo.project_a_section.Banner.BannerBeanOne;
import com.example.dllo.project_a_section.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/8.
 */

public class OneAdapter extends BaseAdapter {
    private ArrayList<OneBean> data;
    private Context context ;

    public OneAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<OneBean> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.get(0).getData().getPosts().size();
    }

    @Override
    public Object getItem(int i) {
        return data != null ? data.get(0).getData().getPosts().get(i):null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder holder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_one,viewGroup,false);
            holder = new MyViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (MyViewHolder) view.getTag();
        }
        holder.textView_title.setText(data.get(0).getData().getPosts().get(i).getAuthor().getNickname());
        holder.textView_low_title.setText(data.get(0).getData().getPosts().get(i).getAuthor().getIntroduction());
        holder.textView_Article.setText(data.get(0).getData().getPosts().get(i).getTitle());
        holder.textView_opuscule.setText(data.get(0).getData().getPosts().get(i).getIntroduction());
        holder.textView_column.setText(data.get(0).getData().getPosts().get(i).getColumn().getTitle());
        //     holder.textView_hart.setText(data.get(0).getData().getItems().get(i).getLikes_count());
        Picasso.with(context).load(data.get(0).getData().getPosts().get(i).getAuthor().getAvatar_url()).into(holder.imageView_Head_portrait);
        Picasso.with(context).load(data.get(0).getData().getPosts().get(i).getCover_image_url()).into(holder.imageView_pager);
        return view;
    }


    class MyViewHolder {
        private TextView textView_title , textView_low_title,textView_Article,textView_opuscule,textView_column,textView_hart;
        private ImageView imageView_Head_portrait,imageView_pager;
        public MyViewHolder (View view){
            textView_title = (TextView) view.findViewById(R.id.tv_home_title_One);
            textView_low_title = (TextView) view.findViewById(R.id.tv_home_one_low_title_One);
            textView_Article = (TextView) view.findViewById(R.id.tv_home_Article_One);
            textView_opuscule = (TextView) view.findViewById(R.id.tv_home_opuscule_One);
            textView_column = (TextView) view.findViewById(R.id.tv_home_column_One);
            textView_hart = (TextView) view.findViewById(R.id.tv_hard_One);
            imageView_Head_portrait = (ImageView) view.findViewById(R.id.iv_home_Head_portrait_One);
            imageView_pager = (ImageView) view.findViewById(R.id.iv_home_pager_One);
        }
    }
}
