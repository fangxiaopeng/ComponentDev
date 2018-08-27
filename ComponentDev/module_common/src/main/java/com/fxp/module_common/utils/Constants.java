package com.fxp.module_common.utils;

/**
 * Title:       Constants
 * <p>
 * Package:     com.fxp.module_common.utils
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/12 下午3:55
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/7/12    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class Constants {

    /************************************************ 个人主页配置 ************************************************/
    /**
     * 个人信息
     */
    public final static String PATH_HOMEPAGE_UERRINFO = "homepage/api/userInfo.json";

    /**
     * 开源项目
     */
    public final static String PATH_HOMEPAGE_PROJECTINFO = "homepage/api/projectInfo.json";

    /**
     * 博客文章
     */
    public final static String PATH_HOMEPAGE_BLOGINFO = "homepage/api/blogInfo.json";

    /**
     * 留言板
     */
    public final static String PATH_HOMEPAGE_MSGBOARDINFO = "homepage/api/msgBoardInfo.json";

    /**
     * 底部信息（友情链接 + 版权）
     */
    public final static String PATH_HOMEPAGE_FOOTERINFO = "homepage/api/footerInfo.json";


    /************************************************ 本地路径配置 ************************************************/
    /**
     * Web版本个人主页
     */
    public final static String PATH_HOMEPAGE_INDEX = "file:///android_asset/homepage/www/html/main-native.html";


    /************************************************ 隐式调用action ************************************************/
    /**
     * WebView容器，Activity-Web
     */
    public final static String ACTION_WEBVIEW_ACTIVITY1 = "com.fxp.module_cordova.activity.CordovaLoadActivity";

    /**
     * WebView容器，Activity-Fragment-Web
     */
    public final static String ACTION_WEBVIEW_ACTIVITY2 = "com.fxp.module_cordova.activity.CordovaFragmentActivity";

    /**
     * 个人主页
     */
    public final static String ACTION_HOMEPAGE_ACTIVITY = "com.fxp.module_homepage.activity.MainActivity";

    /**
     * 个人信息
     */
    public final static String ACTION_USERINFO_ACTIVITY = "com.fxp.module_personalpage.activity.MainActivity";

}
