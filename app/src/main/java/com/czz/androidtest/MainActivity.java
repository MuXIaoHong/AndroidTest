package com.czz.androidtest;


import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.czz.mylibrary.LibClass;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        String appDir = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // 使用api11 新加 api
            //   appDir = "/data/user/0/com.czz.gov/files/bjzwt/app";
            appDir = getApplication().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        } else {
            appDir = Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + "/bjzwt/app";
        }
        LibClass libClass = new LibClass();
        boolean b = libClass.setWorkDir(appDir);
        Log.e("结果", b + "");
    }

    private void initView() {
        webView = (WebView) findViewById(R.id.webView);
    }
}
