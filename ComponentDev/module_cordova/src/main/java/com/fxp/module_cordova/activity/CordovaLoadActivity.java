package com.fxp.module_cordova.activity;

import android.os.Bundle;
import android.util.Log;

import framework.src.org.apache.cordova.CordovaActivity;
import framework.src.org.apache.cordova.CordovaWebView;

/**
 * Title:       CordovaLoadActivity
 * <p>
 * Package:     com.fxp.module_cordova.activity
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/21 下午7:08
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/7/21    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class CordovaLoadActivity extends CordovaActivity{

    private final static String TAG = CordovaLoadActivity.class.getSimpleName();

    private String pageUrl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            pageUrl = extras.getString("startUrl", "file:///android_asset/homepage/www/html/main-native.html");
        }else {
            pageUrl = "file:///android_asset/homepage/www/html/main-native.html";
        }

        loadUrl(pageUrl);
    }

    /**
     * @Description:    获取页面加载状态消息
     * 由CordovaWebViewImpl类发送，pluginManager.postMessage(id, data);
     *
     * @Author:  fxp
     * @Date:    2018/7/21   下午5:51
     * @param    id
     * @param    data
     * @return   java.lang.Object
     * @exception/throws
     */
    @Override
    public Object onMessage(String id, Object data) {
        if ("onPageFinished".equals(id)) {
            Log.e(TAG, "onPageFinished-" + pageUrl);
        }
        return super.onMessage(id, data);
    }

    public CordovaWebView getWebInterface() { return this.appView; }

}
