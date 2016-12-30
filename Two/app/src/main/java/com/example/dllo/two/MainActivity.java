package com.example.dllo.two;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout L1;

    //手势检测器
    private GestureDetector G1;

    private int[] ResId = new int[]{
            R.mipmap.one,R.mipmap.two,R.mipmap.four
    };
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setListener();
    }

    private void setListener() {
         G1 = new GestureDetector(this, (GestureDetector.OnGestureListener) G1);
    }

    private void findView() {
    }
}
