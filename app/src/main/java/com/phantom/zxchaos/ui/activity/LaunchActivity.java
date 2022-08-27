package com.phantom.zxchaos.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.phantom.zxchaos.R;
import com.phantom.zxchaos.base.BaseActivity;

/**
 * @author Soul
 */
public class LaunchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        initData();
    }

    protected void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    LaunchActivity.this.startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                    finish();
                }
            }
        }).start();
    }
}