package com.example.dllo.project_a_section.Cata.CateRvLv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.project_a_section.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/12/1.
 */

public class SingAdapterGird extends BaseAdapter {
    private List<SingBean.DataBean.CategoriesBean.SubcategoriesBean> datas;
    private Context context;
    private int selectIndex;

    public SingAdapterGird(Context context) {
        this.context = context;
    }

    public void setSelectIndex(int selectIndex) {
        this.selectIndex = selectIndex;
    }

    public void setDatas(List<SingBean.DataBean.CategoriesBean.SubcategoriesBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas!=null&&datas.size()>0?datas.size():0;
    }

    @Override
    public Object getItem(int i) {
        return datas!=null?datas.get(i):null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyInViewHolder holder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_gird_sing,viewGroup,false);
            holder = new MyInViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (MyInViewHolder) view.getTag();
        }
        holder.tv.setText(datas.get(i).getName());
        Picasso.with(context).load(datas.get(i).getIcon_url()).into(holder.iv);
        return view;
    }
    class MyInViewHolder{
        private ImageView iv;
        private TextView tv;
        public MyInViewHolder(View view){
            iv = (ImageView) view.findViewById(R.id.item_gird_sing_iv);
            tv = (TextView) view.findViewById(R.id.item_gird_sing_tv);
        }
    }
}
