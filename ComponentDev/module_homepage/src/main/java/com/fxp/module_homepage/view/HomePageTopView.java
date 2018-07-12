package com.fxp.module_homepage.view;

import android.content.Context;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.Toast;

import com.fxp.module_homepage.inter.RefreshListener;
import com.fxp.module_homepage.inter.RequestListener;
import com.fxp.module_homepage.model.UserInfoBean;

import io.reactivex.annotations.NonNull;

/**
 * Title:       HomePageTopView
 * <p>
 * Package:     com.fxp.module_homepage.view
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/9 下午6:20
 * <p>
 * Description: 个人主页-（顶部）个人信息视图
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/7/9    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class HomePageTopView extends BaseView implements RefreshListener{

    private final static String TAG = HomePageTopView.class.getSimpleName();

    public HomePageTopView(Context context, ScrollView mainView){
        super(context, mainView);

    }

    @Override
    protected void findViews() {

    }

    @Override
    protected void initViews() {
        refreshViews();
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void refresh() {
        refreshViews();
    }

    /**
     * @Description: 刷新视图
     *
     * @Author:  fxp
     * @Date:    2018/7/12   上午11:36
     * @param
     * @return   void
     * @exception/throws
     */
    private void refreshViews(){
        requestData("homepage/api/userInfo.json", UserInfoBean.class, new RequestListener() {
            @Override
            public void onSuccess(Object object) {
                UserInfoBean userInfoBean = (UserInfoBean)object;
                if (userInfoBean != null){
                    updateUI(userInfoBean);
                }
            }

            @Override
            public void onFailed(String error) {
                Toast.makeText(context, "RequestData Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * @Description: 更新UI
     *
     * @Author:  fxp
     * @Date:    2018/7/12   上午11:39
     * @param    userInfoBean
     * @return   void
     * @exception/throws
     */
    private void updateUI(@NonNull UserInfoBean userInfoBean){
        Log.e(TAG, "updateUI");

    }
}
