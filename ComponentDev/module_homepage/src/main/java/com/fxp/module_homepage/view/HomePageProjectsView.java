package com.fxp.module_homepage.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.Toast;

import com.fxp.module_common.inter.OnItemClickListener;
import com.fxp.module_common.inter.RefreshListener;
import com.fxp.module_common.recyclerview.GridItemDecoration;
import com.fxp.module_common.utils.Constants;
import com.fxp.module_common.utils.DensityUtils;
import com.fxp.module_homepage.R;
import com.fxp.module_homepage.adapter.HomePageProjectAdapter;
import com.fxp.module_homepage.inter.RequestListener;
import com.fxp.module_homepage.model.ProjectInfoBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

/**
 * Title:       HomePageProjectsView
 * <p>
 * Package:     com.fxp.module_homepage.view
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/10 上午10:19
 * <p>
 * Description: 个人主页-开源项目视图
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
public class HomePageProjectsView extends BaseView implements RefreshListener, OnItemClickListener{

    private final static String TAG = HomePageProjectsView.class.getSimpleName();

    private RecyclerView projectRecyclerView;

    private HomePageProjectAdapter homePageProjectAdapter;

    private List<ProjectInfoBean.ProjectBean> projectBeanList;

    public HomePageProjectsView(Context context, ScrollView mainView){
        super(context, mainView);

    }

    @Override
    protected void findViews() {
        projectRecyclerView = mainView.findViewById(R.id.rv_projects_list);
    }

    @Override
    protected void initViews() {

        initProjectList();

        refreshViews();

    }

    @Override
    protected void initDatas() {
        projectBeanList = new ArrayList<ProjectInfoBean.ProjectBean>();
    }

    @Override
    protected void initListener() {
        homePageProjectAdapter.setItemClickListener(this);
    }

    @Override
    public void refresh() {
        refreshViews();
    }

    @Override
    public void onItemClick(int position) {
        toDetailPage(projectBeanList.get(position).getLink());
    }

    /**
     * @Description:    刷新视图
     *
     * @Author:  fxp
     * @Date:    2018/7/15   下午12:01
     * @param
     * @return   void
     * @exception/throws
     */
    private void refreshViews(){
        requestData(Constants.PATH_HOMEPAGE_PROJECTINFO, ProjectInfoBean.class, new RequestListener() {
            @Override
            public void onSuccess(Object object) {
                ProjectInfoBean projectBean = (ProjectInfoBean)object;
                if (projectBean != null){
                    updateUI(projectBean);
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
     * @Date:    2018/7/15   上午12:10
     * @param    projectBean
     * @return   void
     * @exception/throws
     */
    private void updateUI(@NonNull ProjectInfoBean projectBean){
        Log.i(TAG, "updateUI");

        updateProjectList(projectBean);
    }

    private void initProjectList(){
        GridLayoutManager layoutManager = new GridLayoutManager(context, 2);
        projectRecyclerView.setLayoutManager(layoutManager);
        projectRecyclerView.addItemDecoration(new GridItemDecoration(2, DensityUtils.dp2px(context, 5), true));
        homePageProjectAdapter = new HomePageProjectAdapter(context, projectBeanList);
        projectRecyclerView.setAdapter(homePageProjectAdapter);
        // 解决ScrollView嵌套ScrollView滑动冲突（不流畅），https://www.jianshu.com/p/7e17e48e6baf
        projectRecyclerView.setNestedScrollingEnabled(false);
    }

    /**
     * @Description: 更新开源项目列表
     *
     * @Author:  fxp
     * @Date:    2018/7/15   上午12:18
     * @param    projectBean
     * @return   void
     * @exception/throws
     */
    private void updateProjectList(@NonNull ProjectInfoBean projectBean){
        projectBeanList.clear();
        projectBeanList.addAll(projectBean.getProject_list());
        if (homePageProjectAdapter == null){
            homePageProjectAdapter = new HomePageProjectAdapter(context, projectBeanList);
            projectRecyclerView.setAdapter(homePageProjectAdapter);
        }else {
            homePageProjectAdapter.notifyDataSetChanged();
        }
    }
}
