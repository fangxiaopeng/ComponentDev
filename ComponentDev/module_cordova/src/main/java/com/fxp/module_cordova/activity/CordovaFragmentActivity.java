package com.fxp.module_cordova.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fxp.module_cordova.R;
import com.fxp.module_cordova.fragment.MainFragment;

/**  
 * @Description: Activity中使用Fragment加载网页
 * 
 * @Author:  fxp
 * @Date:    2018/7/21   下午6:25
 * @param
 * @return
 * @exception/throws
 */  
public class CordovaFragmentActivity extends AppCompatActivity {

    private final static String TAG = CordovaFragmentActivity.class.getSimpleName();

    private String pageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cordova_fragment);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            pageUrl = extras.getString("startUrl", "file:///android_asset/www/test/index.html");
        }else {
            pageUrl = "file:///android_asset/www/test/index.html";
        }

        addFragment(pageUrl);
    }

    private void addFragment(String url){
        MainFragment mainFragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        mainFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.root_layout, mainFragment).commitAllowingStateLoss();
    }

}
