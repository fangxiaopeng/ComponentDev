package com.fxp.module_homepage.controller;

import android.content.Context;
import android.view.View;
import android.widget.ScrollView;

import com.fxp.module_homepage.R;
import com.fxp.module_homepage.view.HomePageTopView;

/**
 * Title:       HomePageViewController
 * <p>
 * Package:     com.fxp.module_homepage.ui
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/9 下午6:18
 * <p>
 * Description: 个人主页controller
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/7/9    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class HomePageMainController {

    private final static String TAG = HomePageMainController.class.getSimpleName();

    private Context context;

    private View view;

    public HomePageMainController(Context context, View view){

        this.context = context;
        this.view = view;

        initViews();
    }

    private void initViews(){
        ScrollView mainView = view.findViewById(R.id.scroll_main);

        new HomePageTopView(context, mainView);
    }
}
