package com.fxp.module_homepage.view;

import android.content.Context;

import com.fxp.module_homepage.inter.RefreshListener;

/**
 * Title:       BaseView
 * <p>
 * Package:     com.fxp.module_homepage.view
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/9 下午5:55
 * <p>
 * Description: 个人主页视图基类
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
public abstract class BaseView {

    private final static String TAG = BaseView.class.getSimpleName();

    private Context context;

    protected RefreshListener refreshListener;

    public BaseView(Context context){

        this.context = context;

        findViews();

        initDatas();

        initViews();

        initListener();

        setRefreshListener((RefreshListener)this);
    }

    abstract protected void findViews();

    abstract protected void initViews();

    abstract protected void initDatas();

    abstract protected void initListener();

    protected void setRefreshListener(RefreshListener listener){
        this.refreshListener = listener;
    }

    private void refreshViews(){
        if (refreshListener != null){
            refreshListener.refresh();
        }
    }

}
