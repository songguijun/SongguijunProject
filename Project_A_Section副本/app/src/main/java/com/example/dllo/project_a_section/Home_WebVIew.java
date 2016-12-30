package com.example.dllo.project_a_section;

import android.content.Intent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.dllo.project_a_section.Base.BaseActivity;

/**
 * Created by dllo on 16/12/8.
 */

public class Home_WebVIew extends BaseActivity {
    private WebView webView;
    @Override
    protected int setLayout() {
        return R.layout.web_view_activity;
    }

    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.webView);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("Key");
        String url = "http://www.liwushuo.com/posts/"+ name +"/content";
       webView.loadUrl(url);
//        webView.setFocusable(true);
//        webView.setWebViewClient(webViewClient);
//        webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//        webSettings.setDefaultFixedFontSize(100);
    }
}
