package com.fxp.module_homepage.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.fxp.module_common.utils.Constants;
import com.fxp.module_common.utils.ContextUtils;
import com.fxp.module_common.utils.IntentUtils;
import com.fxp.module_homepage.R;
import com.fxp.module_homepage.controller.HomePageMainController;

import java.io.File;

/**
 * 个人主页
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final static String TAG = MainActivity.class.getSimpleName();

    private Context context;

    private Toolbar toolbar;

    private DrawerLayout drawerLayout;

    private NavigationView navigationView;

    private FloatingActionButton floatingActionBtn;

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = ContextUtils.getContext();

        view = LayoutInflater.from(this).inflate(R.layout.homepage_activity_main,null);

        setContentView(view);

        new HomePageMainController(context, view);

        findViews();

        initDatas();

        initViews();

        initListeners();
    }

    private void findViews() {
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        floatingActionBtn = findViewById(R.id.btn_floating_action);
    }

    public void initDatas() {

    }

    public void initViews() {

        findViews();

        // 显示actionBar
        setSupportActionBar(toolbar);

        initNavigationView();
    }

    public void initListeners() {
        floatingActionBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_floating_action) {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        } else {
        }
    }

    /**
     * @Description: 初始化侧边栏
     *
     * @Author:  fxp
     * @Date:    2018/8/27   下午3:25
     * @param
     * @return   void
     * @exception/throws
     */
    private void initNavigationView() {
        // 左上角打开左侧栏按钮
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        // 动态设置左侧栏头部(不会覆盖xml布局中app:headerLayout设置，会都显示)
//        navigationView.inflateHeaderView(R.layout.nav_header_main);

        // 动态设置左侧栏导航列表(不会覆盖xml布局中app:menu设置，会都显示)
//        navigationView.inflateMenu(R.menu.activity_main_drawer);

        onNavgationViewMenuItemSelected(navigationView);
    }

    /**
     * @Description: NavigationView侧栏menu列表的item点击事件
     *
     * @Author:  fxp
     * @Date:    2018/8/27   下午3:25
     * @param    mNav
     * @return   void
     * @exception/throws
     */
    private void onNavgationViewMenuItemSelected(NavigationView mNav) {
        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.nav_user_info) {
                    // 跳转到个人信息
                    IntentUtils.startActivity(context, IntentUtils.getUserInfoIntent());
                } else if (id == R.id.nav_web_version) {
                    // 跳转到Web版本
                    IntentUtils.startActivity(context, IntentUtils.getWebViewIntent1(Constants.PATH_HOMEPAGE_INDEX));
                } else if (id == R.id.nav_share) {// Handle the nav_share action
//                    shareFile(context.getApplicationInfo().publicSourceDir);
                } else if (id == R.id.nav_send) {// Handle the nav_send action

                } else {
                }

                // Menu item点击后选中
                menuItem.setChecked(true);

                // 关闭Drawerlayout
                drawerLayout.closeDrawers();

                return true;
            }
        });
    }

    /**
     * @Description: 分享文件
     *
     * @Author:  fxp
     * @Date:    2018/8/29   下午3:16
     * @param    filePath
     * @return   void
     * @exception/throws
     */
    private void shareFile(String filePath) {
        try{
            File file = new File(filePath);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setType("*/*");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
