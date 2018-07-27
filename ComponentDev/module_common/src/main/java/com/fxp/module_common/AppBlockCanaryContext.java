package com.fxp.module_common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.fxp.module_common.utils.ContextUtils;
import com.github.moduth.blockcanary.BlockCanaryContext;

import java.util.List;

/**
 * Title:       AppBlockCanaryContext
 * <p>
 * Package:     com.fxp.module_common
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/27 下午6:36
 * <p>
 * Description: BlockCanary
 * 参考资料：https://www.jianshu.com/p/cd7fc77405ac
 * 项目地址：https://github.com/markzhai/AndroidPerformanceMonitor
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/7/27    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class AppBlockCanaryContext extends BlockCanaryContext{

    private final static String TAG = AppBlockCanaryContext.class.getSimpleName();

    @Override
    public String provideQualifier() {
        String qualifier = "";
        try {
            PackageInfo info = ContextUtils.getContext().getPackageManager()
                    .getPackageInfo(ContextUtils.getContext().getPackageName(), 0);
            qualifier += info.versionCode + "_" + info.versionName + "_FXP";
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "provideQualifier exception", e);
        }
        return qualifier;
    }

    @Override
    public int provideMonitorDuration() {
        return 9999;
    }

    @Override
    public int provideBlockThreshold() {
        return 500;
    }

    @Override
    public boolean displayNotification() {
        return BuildConfig.DEBUG;
    }

    @Override
    public List<String> concernPackages() {
        List<String> list = super.provideWhiteList();
        list.add("com.example");
        return list;
    }

    @Override
    public List<String> provideWhiteList() {
        List<String> list = super.provideWhiteList();
        list.add("com.whitelist");
        return list;
    }

    @Override
    public boolean stopWhenDebugging() {
        return true;
    }

}
