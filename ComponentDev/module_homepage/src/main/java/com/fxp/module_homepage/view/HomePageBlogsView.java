package com.fxp.module_homepage.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.fxp.module_common.inter.OnItemClickListener;
import com.fxp.module_common.inter.RefreshListener;
import com.fxp.module_common.recyclerview.LinearItemDecoration;
import com.fxp.module_common.utils.Constants;
import com.fxp.module_common.utils.DensityUtils;
import com.fxp.module_homepage.R;
import com.fxp.module_homepage.adapter.HomePageBlogAdapter;
import com.fxp.module_homepage.inter.RequestListener;
import com.fxp.module_homepage.model.BlogInfoBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

/**
 * Title:       HomePageBlogsView
 * <p>
 * Package:     com.fxp.module_homepage.view
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/10 上午10:25
 * <p>
 * Description: 个人主页-博客文章视图
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
public class HomePageBlogsView extends BaseView implements RefreshListener, OnItemClickListener, View.OnClickListener {

    private final static String TAG = HomePageBlogsView.class.getSimpleName();

    private TextView viewMoreTextView;

    private RecyclerView blogRecyclerView;

    private HomePageBlogAdapter homePageBlogAdapter;

    private List<BlogInfoBean.BlogBean> blogBeanList;

    private BlogInfoBean blogInfo;

    public HomePageBlogsView(Context context, ScrollView mainView){
        super(context, mainView);

    }

    @Override
    protected void findViews() {
        blogRecyclerView = mainView.findViewById(R.id.rv_blogs_list);
        viewMoreTextView = mainView.findViewById(R.id.txt_view_more);
    }

    @Override
    protected void initViews() {

        initBlogList();

        refreshViews();

    }

    @Override
    protected void initDatas() {
        blogBeanList = new ArrayList<BlogInfoBean.BlogBean>();
    }

    @Override
    protected void initListener() {
        viewMoreTextView.setOnClickListener(this);
        homePageBlogAdapter.setItemClickListener(this);
    }

    @Override
    public void refresh() {
        refreshViews();
    }

    /**
     * @Description:    刷新视图
     *
     * @Author:  fxp
     * @Date:    2018/7/15   下午18:01
     * @param
     * @return   void
     * @exception/throws
     */
    private void refreshViews(){
        requestData(Constants.PATH_HOMEPAGE_BLOGINFO, BlogInfoBean.class, new RequestListener() {
            @Override
            public void onSuccess(Object object) {
                BlogInfoBean blogInfoBean = (BlogInfoBean)object;
                if (blogInfoBean != null){
                    updateUI(blogInfoBean);
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
     * @Date:    2018/7/15   下午18:10
     * @param    blogInfoBean
     * @return   void
     * @exception/throws
     */
    private void updateUI(@NonNull BlogInfoBean blogInfoBean){
        Log.i(TAG, "updateUI");

        updateBlogList(blogInfoBean);
    }

    private void initBlogList(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        blogRecyclerView.setLayoutManager(layoutManager);
        blogRecyclerView.addItemDecoration(new LinearItemDecoration(DensityUtils.dp2px(context, 5)));
        homePageBlogAdapter = new HomePageBlogAdapter(context, blogBeanList);
        blogRecyclerView.setAdapter(homePageBlogAdapter);
    }

    /**
     * @Description: 更新博客文章列表
     *
     * @Author:  fxp
     * @Date:    2018/7/15   下午18:18
     * @param    blogInfoBean
     * @return   void
     * @exception/throws
     */
    private void updateBlogList(@NonNull BlogInfoBean blogInfoBean){
        blogInfo = blogInfoBean;

        blogBeanList.clear();
        blogBeanList.addAll(blogInfoBean.getArticle_list());
        if (homePageBlogAdapter == null){
            homePageBlogAdapter = new HomePageBlogAdapter(context, blogBeanList);
            blogRecyclerView.setAdapter(homePageBlogAdapter);
        }else {
            homePageBlogAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(int position) {
        toDetailPage(blogBeanList.get(position).getLink());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.txt_view_more){
            toDetailPage(blogInfo.getBlog_address());
        }
    }
}
