package com.example.dllo.project_a_section.Home.Popup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.project_a_section.Cata.CateRvLv.SingBean;
import com.example.dllo.project_a_section.Home.CardView.GardVIewBean;
import com.example.dllo.project_a_section.Home.CardView.GardViewAdapter;
import com.example.dllo.project_a_section.Home.TableHomeBean;
import com.example.dllo.project_a_section.R;
import com.example.dllo.project_a_section.Volley.NetListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/12/3.
 */

public class GirdAdapterPop extends BaseAdapter {
    private TableHomeBean Bean;
    private Context context ;

    public GirdAdapterPop(Context context) {
        this.context = context;
    }

    public void setBean(TableHomeBean bean) {
        Bean = bean;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return Bean != null ? Bean.getData().getChannels().size() :0;
    }

    @Override
    public Object getItem(int i) {
        return Bean != null ?Bean.getData().getChannels().get(i) : null;
    }


    @Override
    public long getItemId(int i) {
       return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
         MyViewHolder holder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.pop_img,viewGroup,false);
            holder = new MyViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (MyViewHolder) view.getTag();
        }
        holder.tv.setText(Bean.getData().getChannels().get(i).getName());
        return view;
    }


    class MyViewHolder {
        private TextView tv;
        public MyViewHolder (View view){
            tv = (TextView) view.findViewById(R.id.popup_tv);
        }
    }
}
