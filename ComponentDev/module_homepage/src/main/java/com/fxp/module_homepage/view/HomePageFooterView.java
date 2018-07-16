package com.fxp.module_homepage.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.fxp.module_common.inter.OnItemClickListener;
import com.fxp.module_common.inter.RefreshListener;
import com.fxp.module_common.utils.Constants;
import com.fxp.module_homepage.R;
import com.fxp.module_homepage.adapter.HomePageFriendLinkAdapter;
import com.fxp.module_homepage.inter.RequestListener;
import com.fxp.module_homepage.model.FooterInfoBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

/**
 * Title:       HomePageFooterView
 * <p>
 * Package:     com.fxp.module_homepage.view
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/10 下午3:09
 * <p>
 * Description: 个人主页-底部视图
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/7/10    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class HomePageFooterView extends BaseView implements RefreshListener, OnItemClickListener{

    private final static String TAG = HomePageFooterView.class.getSimpleName();

    private TextView copyrightTextView;

    private RecyclerView friendLinkRecyclerView;

    private HomePageFriendLinkAdapter friendLinkAdapter;

    private List<FooterInfoBean.FriendLink> friendLinkList;

    public HomePageFooterView(Context context, ScrollView mainView){
        super(context, mainView);

    }

    @Override
    protected void findViews() {
        copyrightTextView = mainView.findViewById(R.id.txt_copyright);
        friendLinkRecyclerView = mainView.findViewById(R.id.rv_friend_links_list);
    }

    @Override
    protected void initViews() {

        initFriendLinkList();

        refreshViews();

    }

    @Override
    protected void initDatas() {
        friendLinkList = new ArrayList<FooterInfoBean.FriendLink>();
    }

    @Override
    protected void initListener() {
        friendLinkAdapter.setItemClickListener(this);
    }

    @Override
    public void refresh() {
        refreshViews();
    }

    /**
     * @Description: 刷新视图
     *
     * @Author:  fxp
     * @Date:    2018/7/15   下午20:36
     * @param
     * @return   void
     * @exception/throws
     */
    private void refreshViews(){
        requestData(Constants.PATH_HOMEPAGE_FOOTERINFO, FooterInfoBean.class, new RequestListener() {
            @Override
            public void onSuccess(Object object) {
                FooterInfoBean footerInfoBean = (FooterInfoBean)object;
                if (footerInfoBean != null){
                    updateUI(footerInfoBean);
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
     * @Date:    2018/7/15   下午20:39
     * @param    footerInfoBean
     * @return   void
     * @exception/throws
     */
    private void updateUI(@NonNull FooterInfoBean footerInfoBean){
        Log.i(TAG, "updateUI");

        copyrightTextView.setText("Copyright @ " + footerInfoBean.getCopyright());

        updateFriendLinkList(footerInfoBean);
    }

    private void initFriendLinkList(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        friendLinkRecyclerView.setLayoutManager(layoutManager);
        friendLinkAdapter = new HomePageFriendLinkAdapter(context, friendLinkList);
        friendLinkRecyclerView.setAdapter(friendLinkAdapter);
    }

    /**
     * @Description: 更新友情链接
     *
     * @Author:  fxp
     * @Date:    2018/7/15   下午20:55
     * @param    footerInfoBean
     * @return   void
     * @exception/throws
     */
    private void updateFriendLinkList(@NonNull FooterInfoBean footerInfoBean){
        friendLinkList.clear();
        friendLinkList.addAll(footerInfoBean.getFriend_links());
        if (friendLinkAdapter == null){
            friendLinkAdapter = new HomePageFriendLinkAdapter(context, friendLinkList);
            friendLinkRecyclerView.setAdapter(friendLinkAdapter);
        }else {
            friendLinkAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(int position) {
        toDetailPage(friendLinkList.get(position).getLink());
    }
}
