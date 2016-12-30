package com.example.dllo.project_a_section.Banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.example.dllo.project_a_section.Home.GIrLBean;
import com.example.dllo.project_a_section.Home.GirlAdapter;
import com.example.dllo.project_a_section.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/6.
 */

public class BannerAdapter extends BaseAdapter  {
    private ArrayList<BannerBeanOne> data;
    private Context context ;

    public BannerAdapter(Context context) {
        this.context = context;
    }


    public void setData(ArrayList<BannerBeanOne> data) {
        this.data = data;
        notifyDataSetChanged();
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
            view = LayoutInflater.from(context).inflate(R.layout.item_banner,viewGroup,false);
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
            textView_title = (TextView) view.findViewById(R.id.tv_home_title_ban);
            textView_low_title = (TextView) view.findViewById(R.id.tv_home_one_low_title_ban);
            textView_Article = (TextView) view.findViewById(R.id.tv_home_Article_ban);
            textView_opuscule = (TextView) view.findViewById(R.id.tv_home_opuscule_ban);
            textView_column = (TextView) view.findViewById(R.id.tv_home_column_ban);
            textView_hart = (TextView) view.findViewById(R.id.tv_hard_ban);
            imageView_Head_portrait = (ImageView) view.findViewById(R.id.iv_home_Head_portrait_ban);
            imageView_pager = (ImageView) view.findViewById(R.id.iv_home_pager_ban);
        }
    }
}
