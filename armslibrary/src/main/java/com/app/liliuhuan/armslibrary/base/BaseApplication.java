package com.app.liliuhuan.armslibrary.base;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.app.liliuhuan.armslibrary.delegate.AppDelegate;
import com.app.liliuhuan.armslibrary.lifecycle.app.AppLifecycles;
import com.app.liliuhuan.armslibrary.delegate.IApp;
import com.app.liliuhuan.armslibrary.di.component.AppComponent;
import com.app.liliuhuan.armslibrary.util.Preconditions;

/**
 * MVPArms 是一个整合了大量主流开源项目的 Android MVP 快速搭建框架, 其中包含 Dagger2、Retrofit、RxJava 以及
 * RxLifecycle、RxCache 等 Rx 系三方库, 并且提供 UI 自适应方案, 本框架将它们结合起来, 并全部使用 Dagger2 管理
 * 并提供给开发者使用, 使用本框架开发您的项目, 就意味着您已经拥有一个 MVP + Dagger2 + Retrofit + RxJava 项目
 * <p>
 * author: 李刘欢
 * date：2018/12/21 14:22
 * version:1.0.0
 * description: BaseApplication
 */
public class BaseApplication extends Application implements IApp {
    private AppLifecycles mAppDelegate;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        if (mAppDelegate == null) {
            this.mAppDelegate = new AppDelegate(base);
        }
        this.mAppDelegate.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.mAppDelegate.onCreate(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        this.mAppDelegate.onTerminate(this);
    }

    @NonNull
    @Override
    public AppComponent getAppComponent() {
        Preconditions.checkNotNull(mAppDelegate, "%s cannot be null", AppDelegate.class.getName());
        Preconditions.checkState(mAppDelegate instanceof IApp, "%s must be implements %s", mAppDelegate.getClass().getName(), IApp.class.getName());
        return ((IApp) mAppDelegate).getAppComponent();
    }
}
