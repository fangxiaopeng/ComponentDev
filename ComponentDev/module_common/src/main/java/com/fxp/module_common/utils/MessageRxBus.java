package com.fxp.module_common.utils;

/**
 * Title:       MessageRxBus
 * <p>
 * Package:     com.example.rxjavademo.rxbus
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/6/25 下午3:42
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/6/25    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */

public class MessageRxBus {

    /**
     * 使用json格式传递数据，以应对不同数据类型
     */
    private String message;

    /**
     * 用于区分不同的事件
     */
    private String id;

    public MessageRxBus(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
