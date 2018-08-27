package com.fxp.module_common.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Title:       IntentUtils
 * <p>
 * Package:     com.fxp.module_common.utils
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/8/27 下午4:36
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/8/27    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class IntentUtils {

    /**
     * @Description:    跳转Activity
     *
     * @Author:  fxp
     * @Date:    2018/8/27   下午4:37
     * @param    context
     * @param    intent
     * @return   void
     * @exception/throws
     */
    public static void startActivity(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Intent error : ", e.toString());
        }
    }

    public static Intent getHomePageIntent() {
        return new Intent(Constants.ACTION_HOMEPAGE_ACTIVITY);
    }

    public static Intent getUserInfoIntent() {
        return new Intent(Constants.ACTION_USERINFO_ACTIVITY);
    }

    public static Intent getWebViewIntent1(String url){
        Intent intent = new Intent(Constants.ACTION_WEBVIEW_ACTIVITY1);
        intent.putExtra("startUrl",url);
        return intent;
    }

    public static Intent getWebViewIntent2(String url){
        Intent intent = new Intent(Constants.ACTION_WEBVIEW_ACTIVITY2);
        intent.putExtra("startUrl",url);
        return intent;
    }
}
