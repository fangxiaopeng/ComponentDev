package com.fxp.module_common.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

/**
 * Title:       ScreenBroadcastReceiver
 * <p>
 * Package:     com.fxp.module_common.broadcast
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/14 下午4:19
 * <p>
 * Description: screen状态广播接收器
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/7/14    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class ScreenBroadcastReceiver extends BroadcastReceiver {

    private final static String TAG = ScreenBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_SCREEN_ON.equals(action)) {   // 开屏
            Log.d(TAG,"ACTION_SCREEN_ON");

        } else if (Intent.ACTION_SCREEN_OFF.equals(action)) {   // 锁屏
            Log.d(TAG,"ACTION_SCREEN_OFF");

        } else if (Intent.ACTION_USER_PRESENT.equals(action)) { // 解锁
            Log.d(TAG,"ACTION_USER_PRESENT");

        }
    }

    /**
     * 启动screen状态广播接收器
     */
    private void registerListener(Context context, ScreenBroadcastReceiver mScreenReceiver ) {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        context.registerReceiver(mScreenReceiver, filter);
    }
}
