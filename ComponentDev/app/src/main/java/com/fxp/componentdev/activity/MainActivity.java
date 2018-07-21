package com.fxp.componentdev.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fxp.componentdev.R;
import com.fxp.module_common.utils.ContextUtils;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cordova_fragment);

        timer.schedule(timerTask, 3000, 1000);

    }

    private Timer timer = new Timer();
    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);
        }
    };

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

//            Intent intent = new Intent("com.fxp.module_homepage.activity.MainActivity");
//            Intent intent = new Intent("com.fxp.module_homepage.activity.WebHomePageActivity");
//            ContextUtils.getContext().startActivity(intent);

            String pageUrl = "file:///android_asset/homepage/www/html/main-native.html";
            toCordovaFragmentActivity(pageUrl);

            timer.cancel();
        }
    };

    /**
     * @Description: 使用CordovaFragmentActivity加载
     *
     * @Author:  fxp
     * @Date:    2018/7/21   下午6:55
     * @param    url
     * @return   void
     * @exception/throws
     */
    private void toCordovaFragmentActivity(String url){
        Intent intent = new Intent("com.fxp.module_cordova.activity.CordovaFragmentActivity");
        intent.putExtra("startUrl",url);
        ContextUtils.getContext().startActivity(intent);
    }
}
