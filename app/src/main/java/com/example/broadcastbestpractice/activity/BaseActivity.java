package com.example.broadcastbestpractice.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.broadcastbestpractice.widget.ActivityCollector;

/**
 * Created by SJC on 2016/9/1.
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
