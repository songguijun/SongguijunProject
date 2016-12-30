package com.example.dllo.project_a_section.Home;

import android.content.Intent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.dllo.project_a_section.Base.BaseActivity;
import com.example.dllo.project_a_section.R;

/**
 * Created by dllo on 16/12/8.
 */

public class GirlWebViewActivity extends BaseActivity {
    private WebView webView;

    @Override
    protected int setLayout() {
        return R.layout.girl_web_view;
    }

    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.girl_Webview);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("Girl");
        String url = "http://www.liwushuo.com/posts/"+name+ "/content";
        webView.loadUrl(url);
    }
}