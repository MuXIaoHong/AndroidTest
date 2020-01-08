package com.czz.androidtest;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    jcifs.Config.registerSmbURLHandler();

                    String user = "zhouyanan";

                    String pass = "Aa111111";

                    String url = "smb://192.168.1.101/share/周亚楠/消息溯源操作名称.txt";

                    NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(

                            null, user, pass);
                    try {
                        final SmbFile sfile = new SmbFile(url, auth);
                        final String f_content = sfile.getContent().toString();
                        final StringBuilder sb = new StringBuilder();
                        sb.append("alert('" + f_content + "')");

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                webView.loadUrl("javascript:" + sb.toString());

                            }
                        });
                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                }
            }).start();


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void initView() {
        webView = (WebView) findViewById(R.id.webView);
    }
}
