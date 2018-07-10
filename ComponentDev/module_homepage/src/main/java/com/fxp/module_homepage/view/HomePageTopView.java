package com.fxp.module_homepage.view;

import android.content.Context;
import android.widget.ScrollView;

import com.fxp.module_homepage.inter.RefreshListener;

/**
 * Title:       HomePageTopView
 * <p>
 * Package:     com.fxp.module_homepage.ui
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/9 下午6:20
 * <p>
 * Description: 个人主页-（顶部）个人信息视图
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
public class HomePageTopView extends BaseView implements RefreshListener{

    private final static String TAG = HomePageTopView.class.getSimpleName();

    private ScrollView mainView;

    public HomePageTopView(Context context, ScrollView mainView){
        super(context);

        this.mainView = mainView;

    }

    @Override
    protected void findViews() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void refresh() {

    }
}
