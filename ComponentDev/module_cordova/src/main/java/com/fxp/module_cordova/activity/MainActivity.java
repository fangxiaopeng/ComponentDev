package com.fxp.module_cordova.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fxp.module_cordova.R;
import com.fxp.module_cordova.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.root_layout, new MainFragment()).commit();

    }
}
