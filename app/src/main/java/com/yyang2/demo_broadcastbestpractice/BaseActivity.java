package com.yyang2.demo_broadcastbestpractice;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by yyang2 on 5/29/2016.
 */
public class BaseActivity extends Activity {

    //add activity to ActivityCollector
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    //remove activity from ActivityCollector
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
