package com.fxp.module_homepage.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.fxp.module_common.utils.Constants;
import com.fxp.module_common.utils.GlideUtil;
import com.fxp.module_homepage.R;
import com.fxp.module_homepage.adapter.HomePageNavAdapter;
import com.fxp.module_common.inter.OnItemClickListener;
import com.fxp.module_common.inter.RefreshListener;
import com.fxp.module_homepage.inter.RequestListener;
import com.fxp.module_homepage.model.UserInfoBean;

import java.util.ArrayList;
import java.util.List;

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
public class HomePageTopView extends BaseView implements RefreshListener, OnItemClickListener{

    private final static String TAG = HomePageTopView.class.getSimpleName();

    private ImageView userPhotoImg;

    private TextView userNameTxt, userDescTxt;

    private RecyclerView navRecyclerView;

    private HomePageNavAdapter homePageNavAdapter;

    private List<UserInfoBean.NavBean> navBeanList;

    public HomePageTopView(Context context, ScrollView mainView){
        super(context, mainView);

    }

    @Override
    protected void findViews() {
        userPhotoImg = mainView.findViewById(R.id.img_user_photo);
        userNameTxt = mainView.findViewById(R.id.txt_user_name);
        userDescTxt = mainView.findViewById(R.id.txt_user_desc);
        navRecyclerView = mainView.findViewById(R.id.rv_nav_list);
    }

    @Override
    protected void initDatas() {
        navBeanList = new ArrayList<UserInfoBean.NavBean>();
    }

    @Override
    protected void initViews() {

        initNavList();

        refreshViews();
    }

    @Override
    protected void initListener() {
        homePageNavAdapter.setItemClickListener(this);
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
        requestData(Constants.PATH_HOMEPAGE_UERRINFO, UserInfoBean.class, new RequestListener() {
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
        Log.i(TAG, "updateUI");
        GlideUtil.setCircleView(context, R.mipmap.img_user, userPhotoImg);
        userNameTxt.setText(userInfoBean.getUser_name());
        userDescTxt.setText(userInfoBean.getUser_desc());
        updateNavList(userInfoBean);
    }

    private void initNavList(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        navRecyclerView.setLayoutManager(layoutManager);
        homePageNavAdapter = new HomePageNavAdapter(context, navBeanList);
        navRecyclerView.setAdapter(homePageNavAdapter);
    }

    /**
     * @Description: 更新导航栏
     *
     * @Author:  fxp
     * @Date:    2018/7/13   上午11:18
     * @param    userInfoBean
     * @return   void
     * @exception/throws
     */
    private void updateNavList(@NonNull UserInfoBean userInfoBean){
        navBeanList = userInfoBean.getUser_nav();
        navRecyclerView.notifyAll();
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(context, "onItemClick-" + position, Toast.LENGTH_SHORT).show();
//        toDetailPage(navBeanList.get(position).getLink());
    }
}
