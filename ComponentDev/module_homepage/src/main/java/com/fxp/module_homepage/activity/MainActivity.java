package com.fxp.module_homepage.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.fxp.module_common.utils.ContextUtils;
import com.fxp.module_homepage.R;
import com.fxp.module_homepage.controller.HomePageMainController;

/**
 * 个人主页
 */
public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    private Context context;

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = ContextUtils.getContext();

        view = LayoutInflater.from(this).inflate(R.layout.homepage_activity_main,null);

        setContentView(view);

        new HomePageMainController(context, view);
    }
}
