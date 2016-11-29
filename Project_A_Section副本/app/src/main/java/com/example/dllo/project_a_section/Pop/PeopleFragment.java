package com.example.dllo.project_a_section.Pop;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dllo.project_a_section.Base.BeasFragment;
import com.example.dllo.project_a_section.R;

/**
 * Created by dllo on 16/11/29.
 */

public class PeopleFragment extends BeasFragment implements View.OnClickListener {
    private ImageView imageViewOne,imageViewTwo,imageViewThree;
    @Override
    protected int setLayout() {
        return R.layout.people_fragment;
    }

    @Override
    protected void initView(View view) {
        imageViewOne = (ImageView) view.findViewById(R.id.imageView_sina);
        imageViewTwo = (ImageView) view.findViewById(R.id.image_wechat);
        imageViewThree = (ImageView) view.findViewById(R.id.imageView_qzone);
    }

    @Override
    public void initData() {
        imageViewOne.setOnClickListener(this);
        imageViewTwo.setOnClickListener(this);
        imageViewThree.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView_sina:
                Toast.makeText(getContext(), "网络连接异常", Toast.LENGTH_SHORT).show();
            case R.id.image_wechat:
                Toast.makeText(getContext(), "没有安装微信", Toast.LENGTH_SHORT).show();
            case R.id.imageView_qzone:
                Toast.makeText(getContext(), "网络连接异常", Toast.LENGTH_SHORT).show();
        }

    }
}
