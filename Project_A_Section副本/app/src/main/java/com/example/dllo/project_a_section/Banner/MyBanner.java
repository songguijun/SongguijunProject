package com.example.dllo.project_a_section.Banner;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/24.
 */

public class MyBanner extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }
}
