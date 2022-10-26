package com.mosapl.actividad1tema4moisessanchis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {
    private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        web = (WebView) findViewById(R.id.wbWeb);
        String url = this.getIntent().getStringExtra("url");
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(url);
    }
}