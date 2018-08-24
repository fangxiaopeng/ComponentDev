package com.fxp.module_personalpage.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fxp.module_personalpage.R;

/**
 * Title:       PersonalInfoFragment
 * <p>
 * Package:     com.fxp.module_personalpage.fragment
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/8/23 下午4:27
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/8/23    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class PersonalInfoFragment extends Fragment {

    private final static String TAG = PersonalInfoFragment.class.getSimpleName();

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        Log.i (TAG, "onInflate");
        super.onInflate(activity, attrs, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        Log.i (TAG, "onAttach");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i (TAG, "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        Log.i (TAG, "onCreateView");
        // inflater.inflate(resource, null);
        return inflater.inflate(R.layout.fragment_personal_info, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.i (TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i (TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i (TAG, "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i (TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i (TAG, "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i (TAG, "onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i (TAG, "onDestroyView");
        super.onDestroyView();
    }
    @Override
    public void onDestroy() {
        Log.i (TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i (TAG, "onDetach");
        super.onDetach();
    }
}
