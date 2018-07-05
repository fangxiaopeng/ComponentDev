package com.fxp.module_common.base;

import android.app.Application;

/**
 * Title:       BaseApplication
 * <p>
 * Package:     com.fxp.module_common.base
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/5 下午6:21
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/7/5    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class BaseApplication extends Application {

    private final static String TAG = BaseApplication.class.getSimpleName();

    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }


}
