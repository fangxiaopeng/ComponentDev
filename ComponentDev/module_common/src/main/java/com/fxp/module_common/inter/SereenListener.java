package com.fxp.module_common.inter;

/**
 * Title:       SereenListener
 * <p>
 * Package:     com.fxp.module_common.inter
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/14 下午4:14
 * <p>
 * Description: 屏幕状态监听接口
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
public interface SereenListener {

    /**
     * 开屏
     */
    void sereenOn();

    /**
     * 锁屏
     */
    void sereenOff();

    /**
     * 解锁
     */
    void sereenPresent();

}
