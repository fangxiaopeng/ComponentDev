package com.fxp.module_common.utils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Title:       RxBus
 * <p>
 * Package:     com.example.rxjavademo.rxbus
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/6/25 下午3:39
 * <p>
 * Description:
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

public class RxBus {

    private final Subject<Object> mBus;

    private RxBus() {
        // toSerialized method made bus thread safe
        mBus = PublishSubject.create().toSerialized();
    }

    public static RxBus get() {
        return Holder.BUS;
    }

    /**
     * 将数据添加到订阅
     */
    public void post(@NonNull Object obj) {
        if (hasObservers()) {
            mBus.onNext(obj);
        }
    }

    /**
     * 将数据添加到订阅 - 集合
     */
    public void post(@NonNull List<Object> obj) {
        if (hasObservers()) {//判断当前是否已经添加订阅
            mBus.onNext(obj);
        }
    }

    public <T> Observable<T> toObservable(Class<T> tClass) {
        return mBus.ofType(tClass);
    }

    /**
     * 注册，传递tClass的时候最好创建一个封装的类。这对数据的传递作用
     * 新更改仅仅抛出生成类和解析
     */
    public <T> Disposable register(Class<T> tClass, Consumer<T> consumer) {
        return toObservable(tClass).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(consumer);
    }

    public <T> Disposable register(Class<T> tClass, Consumer<T> consumer,Consumer<Throwable> throwable) {
        return toObservable(tClass).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(consumer,throwable);
    }

    public Observable<Object> toObservable() {
        return mBus;
    }

    public boolean hasObservers() {
        return mBus.hasObservers();
    }

    private static class Holder {
        private static final RxBus BUS = new RxBus();
    }

}
