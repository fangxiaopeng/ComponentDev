package com.fxp.module_homepage.inter;

/**
 * Title:       RequestListener
 * <p>
 * Package:     com.fxp.module_homepage.inter
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/12 上午10:27
 * <p>
 * Description: 请求结果回调
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
public interface RequestListener {

    void onSuccess(Object obj);

    void onFailed(String error);

}
