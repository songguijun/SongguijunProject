package com.example.dllo.project_a_section.Cata.CateRvLv;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.project_a_section.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by dllo on 16/11/29.
 */

public class SingRvAdapter  extends BaseAdapter  {
    List<SingBean.DataBean.CategoriesBean> datas;
    private Context context;
    private int selectIndex;
    private List<SingBean.DataBean.CategoriesBean.SubcategoriesBean> list;

    public SingRvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<SingBean.DataBean.CategoriesBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void setSelectIndex(int selectIndex) {
        this.selectIndex = selectIndex;
        notifyDataSetChanged();
    }

    public void setList(List<SingBean.DataBean.CategoriesBean.SubcategoriesBean> list) {
        this.list = list;
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
        MyRightViewHolder holder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_hard_rv_sing,viewGroup,false);

            holder = new MyRightViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (MyRightViewHolder) view.getTag();
        }

        SingBean.DataBean.CategoriesBean bean = datas.get(i);
        if (bean.getName().equals("热门分类")){
           // holder.tv.setText(" ");
       //     holder.mview.setBackgroundColor(Color.WHITE);
        }else {
            holder.tv.setText(bean.getName());
      //      holder.mview.setBackgroundColor(Color.argb(255,255,255,255));
        }
        SingAdapterGird adapterGird = new SingAdapterGird(context);
        list = new ArrayList<>();
        list = bean.getSubcategories();
        adapterGird.setDatas(list);
        holder.gv.setAdapter(adapterGird);
        return view;
    }
    public  void setIndex(int index){
        selectIndex = index;
    }

    class MyRightViewHolder{
        private TextView tv;
        private GridView gv;
        private View mview;
        public MyRightViewHolder(View view){
            tv = (TextView) view.findViewById(R.id.tv_rv__hard_sing);
            gv = (GridView) view.findViewById(R.id.sing_gv);
        }
    }
}
