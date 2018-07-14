package com.fxp.module_homepage.view;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ScrollView;

import com.fxp.module_common.utils.AssetsUtil;
import com.fxp.module_common.inter.RefreshListener;
import com.fxp.module_common.utils.Constants;
import com.fxp.module_homepage.inter.RequestListener;
import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Title:       BaseView
 * <p>
 * Package:     com.fxp.module_homepage.view
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/9 下午5:55
 * <p>
 * Description: 个人主页视图基类
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
public abstract class BaseView {

    private final static String TAG = BaseView.class.getSimpleName();

    protected Context context;

    protected ScrollView mainView;

    protected RefreshListener refreshListener;

    public BaseView(Context context, ScrollView mainView){

        this.context = context;

        this.mainView = mainView;

        findViews();

        initDatas();

        initViews();

        initListener();

        setRefreshListener((RefreshListener)this);
    }

    abstract protected void findViews();

    abstract protected void initViews();

    abstract protected void initDatas();

    abstract protected void initListener();

    protected void setRefreshListener(RefreshListener listener){
        this.refreshListener = listener;
    }

    private void refreshViews(){
        if (refreshListener != null){
            refreshListener.refresh();
        }
    }

    /**
     * @Description: 子线程请求数据，请求成功后切回主线程
     * 将请求结果转换成对象
     *
     * @Author:  fxp
     * @Date:    2018/7/12   上午11:28
     * @param    url                请求地址
     * @param    tClass             请求结果类（泛型）
     * @param    requestListener    请求结果回调
     * @return   void
     * @exception/throws
     */
    protected <T> void requestData(final String url, final Class<T> tClass, final RequestListener requestListener){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {
                    emitter.onNext(AssetsUtil.readFile(context, url));
                }catch (Exception e){
                    emitter.onError(e);
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i(TAG, "onSubscribe");
                    }

                    @Override
                    public void onNext(String value) {
                        Log.i(TAG, "onNext: " + value);
                        requestListener.onSuccess(new Gson().fromJson(value, tClass));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError" + e.toString());
                        requestListener.onFailed(e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete");
                    }
                });
    }

    /**
     * @Description: 跳转到详情页-Web
     *
     * @Author:  fxp
     * @Date:    2018/7/14   下午4:32
     * @param    link
     * @return   void
     * @exception/throws
     */
    protected void toDetailPage(String link){
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(context.getPackageName(), Constants.ACTION_WEBVIEW_ACTIVITY));
            intent.putExtra("link", link);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
