package com.example.dllo.project_a_section.Cata.Category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.project_a_section.Base.BeasFragment;
import com.example.dllo.project_a_section.Home.CardView.GardViewAdapter;
import com.example.dllo.project_a_section.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/28.
 */

public class CategoryRvAdapter extends BaseAdapter {
    private ArrayList<CategoryBean>datacate;
    private Context context ;

    public CategoryRvAdapter(Context context) {
        this.context = context;
    }

    public void setDatacate(ArrayList<CategoryBean> data) {
        this.datacate = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datacate.get(0).getData().getChannel_groups().size();
    }

    @Override
    public Object getItem(int i) {
        return datacate != null ? datacate.get(0).getData().getChannel_groups():null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder holder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.cate_category_gird,viewGroup,false);
            holder = new MyViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (MyViewHolder) view.getTag();
        }
        holder.textView.setText(datacate.get(0).getData().getChannel_groups().get(i).getName());
        holder.tv_one.setText(datacate.get(1).getData().getChannel_groups().get(i).getName());
        holder.tv_two.setText(datacate.get(2).getData().getChannel_groups().get(i).getName());
        Picasso.with(context).load(datacate.get(0).getData().getChannel_groups().get(i).getChannels().get(1).getCover_image_url()).into(holder.imageView);
        Picasso.with(context).load(datacate.get(1).getData().getChannel_groups().get(i).getChannels().get(2).getCover_image_url()).into(holder.iv_one);
        Picasso.with(context).load(datacate.get(2).getData().getChannel_groups().get(i).getChannels().get(3).getCover_image_url()).into(holder.iv_two);
        return view;


    }
    class  MyViewHolder {
        private ImageView imageView,iv_one,iv_two;
        private TextView textView ,tv_one,tv_two ;
        public MyViewHolder (View view){
            imageView = (ImageView) view.findViewById(R.id.iv_category);
            iv_one = (ImageView) view.findViewById(R.id.iv_category_one);
            iv_two = (ImageView) view.findViewById(R.id.iv_category_two);
            textView = (TextView) view.findViewById(R.id.tv_category);
            tv_one = (TextView) view.findViewById(R.id.tv_category_one);
            tv_two = (TextView) view.findViewById(R.id.tv_category_two);

        }
    }
}
