package com.example.dllo.project_a_section.Gift;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by dllo on 16/12/9.
 */

public class MyGiftBanner extends ImageLoader {

        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }


