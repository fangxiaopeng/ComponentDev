package com.fxp.module_personalpage.activity;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.fxp.module_personalpage.R;
import com.fxp.module_personalpage.adapter.FragmentViewPagerAdapter;
import com.fxp.module_personalpage.fragment.PersonalInfoFragment;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    private Context context;

    private CollapsingToolbarLayout collapsingToolbarLayout;

    private Toolbar toolbar;

    private TabLayout tabLayout;

    private ViewPager fragmentViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personalinfo_activity_main);

        // 实现沉浸式状态栏
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        findViews();

        initData();

        initViews();

        initListener();
    }

    private void findViews(){
        toolbar = findViewById(R.id.toolbar);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        tabLayout = findViewById(R.id.sliding_tabs);
        fragmentViewPager = findViewById(R.id.viewpager);
    }

    private void initData(){
        context = getApplicationContext();

    }

    private void initViews(){
        initToolbar();

        initCollapsingToolbarLayout();

        initFragmentViewPager();

        initTabLayout();
    }

    private void initListener(){

    }

    /**
     * @Description: 初始化工具栏
     *
     * @Author:  fxp
     * @Date:    2018/8/23   下午7:02
     * @param
     * @return   void
     * @exception/throws
     */
    private void initToolbar(){
        toolbar.setTitle("Title");
        setSupportActionBar(toolbar);
        // 设置左上角返回箭头可见
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    /**
     * @Description: 初始化CollapsingToolbarLayout
     *
     * @Author:  fxp
     * @Date:    2018/8/23   下午7:02
     * @param
     * @return   void
     * @exception/throws
     */
    private void initCollapsingToolbarLayout(){
        // 设置工具栏标题
        collapsingToolbarLayout.setTitle("方晓鹏");
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        // 设置纱布图片，只在LOLLIPOP设备上有用
//        collapsingToolbarLayout.setStatusBarScrim(context.getResources().getDrawable(R.mipmap.img_onepiece));
        collapsingToolbarLayout.setContentScrim(context.getResources().getDrawable(R.mipmap.img_onepiece));
    }

    /**
     * @Description: 初始化ViewPager
     *
     * @Author:  fxp
     * @Date:    2018/8/23   下午7:04
     * @param
     * @return   void
     * @exception/throws
     */
    private void initFragmentViewPager(){
        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PersonalInfoFragment(), "关于");
        adapter.addFragment(new PersonalInfoFragment(), "动态");
        adapter.addFragment(new PersonalInfoFragment(), "作品");
        fragmentViewPager.setAdapter(adapter);
    }

    /**
     * @Description: 初始化TabLayout
     *
     * @Author:  fxp
     * @Date:    2018/8/23   下午7:03
     * @param
     * @return   void
     * @exception/throws
     */
    private void initTabLayout(){
        tabLayout.addTab(tabLayout.newTab().setText("关于"));
        tabLayout.addTab(tabLayout.newTab().setText("动态"));
        tabLayout.addTab(tabLayout.newTab().setText("作品"));
        tabLayout.setupWithViewPager(fragmentViewPager);
    }
}
