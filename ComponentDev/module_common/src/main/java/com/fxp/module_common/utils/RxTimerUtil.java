package com.fxp.module_common.utils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Title:       RxTimerUtil
 * <p>
 * Package:     com.example.rxjavademo.rxtimer
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/6/25 下午10:34
 * <p>
 * Description: 使用Rxjava2.x实现定时器
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/6/25    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class RxTimerUtil {

    private static Disposable mDisposable;

    /**
     * milliseconds毫秒后执行next操作
     *
     * @param milliseconds 毫秒
     * @param next         回调接口
     */
    public void timer(long milliseconds, final IRxNext next) {
        Observable.timer(milliseconds, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                        mDisposable = disposable;
                    }

                    @Override
                    public void onNext(@NonNull Long number) {
                        if (next != null) {
                            next.doNext(number,mDisposable);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        //取消订阅
                        cancel();
                    }

                    @Override
                    public void onComplete() {
                        //取消订阅
                        cancel();
                    }
                });
    }

    /**
     * 每隔milliseconds毫秒后执行next操作
     *
     * @param milliseconds 毫秒
     * @param next         回调接口
     */
    public void interval(long milliseconds, final IRxNext next) {
        Observable.interval(milliseconds, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                        mDisposable = disposable;
                    }

                    @Override
                    public void onNext(@NonNull Long number) {
                        if (next != null) {
                            next.doNext(number,mDisposable);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        //取消订阅
                        cancel();
                    }

                    @Override
                    public void onComplete() {
                        //取消订阅
                        cancel();
                    }
                });
    }


    /**
     * 取消订阅
     */
    public void cancel() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

    public interface IRxNext {
        void doNext(long number, Disposable disposable);
    }

}

