package com.example.dllo.project_a_section.Cata.Category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.dllo.project_a_section.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/11/30.
 */

public class CateGirdOneAdapter extends BaseAdapter {
    private List<CategoryBean> data;
    private Context context ;

    public void setData(List<CategoryBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public CateGirdOneAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return data == null ? 0:6;
    }

    @Override
    public Object getItem(int i) {
        return data != null ? data.get(i):null ;
    }
    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder holder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.cate_image,viewGroup,false);
            holder = new MyViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (MyViewHolder) view.getTag();
        }
        Picasso.with(context).load(data.get(0).getData().getChannel_groups().get(1).getChannels().get(i).getCover_image_url()).into(holder.imageViewone);


        return view;


        //得到GridView每一项的高度与宽度

//设置每一行的高度和宽度



    }

    class MyViewHolder {
        private ImageView imageViewone;
        public MyViewHolder (View view){
            imageViewone = (ImageView) view.findViewById(R.id.cate_iv);
        }

    }
}
