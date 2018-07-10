package com.fxp.module_homepage.view;

import android.content.Context;
import android.widget.ScrollView;

import com.fxp.module_homepage.inter.RefreshListener;

/**
 * Title:       HomePageProjectsView
 * <p>
 * Package:     com.fxp.module_homepage.view
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/10 上午10:19
 * <p>
 * Description: 个人主页-开源项目视图
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/7/10    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class HomePageProjectsView extends BaseView implements RefreshListener{

    private final static String TAG = HomePageProjectsView.class.getSimpleName();

    private Context context;

    private ScrollView mainView;

    public HomePageProjectsView(Context context, ScrollView mainView){
        super(context);

        this.context = context;
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
