package com.fxp.module_cordova.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Title:       MainFragment
 * <p>
 * Package:     com.example.cordova.fragment
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/6/28 上午11:03
 * <p>
 * Description: Fragment中使用CordovaWebView
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/6/28    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class CordovaLoadFragment extends CordovaFragment{

    private static final String TAG = CordovaLoadFragment.class.getSimpleName();

    public CordovaLoadFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String pageUrl = getArguments().getString("url");
        if (pageUrl == null){
            pageUrl = "file:///android_asset/www/htmlnotfound/error.html";
        }

        loadUrl(pageUrl);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
    }

}
