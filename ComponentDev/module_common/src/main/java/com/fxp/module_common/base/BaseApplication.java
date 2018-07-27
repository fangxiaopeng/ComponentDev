package com.fxp.module_common.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.fxp.module_common.utils.ContextUtils;

/**
 * Title:       BaseApplication
 * <p>
 * Package:     com.fxp.module_common.base
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/5 下午6:21
 * <p>
 * Description: 提供全局的Context
 * 作为业务组件和app壳工程中的 Application 的基类
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

        ContextUtils.init(this);

    }

    /**  
     * @Description: 解决android 方法总数超过 65536 问题
     * 
     * @Author:  fxp
     * @Date:    2018/7/27   下午5:53
     * @param    base
     * @return   void 
     * @exception/throws
     */  
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
