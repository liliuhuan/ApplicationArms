package com.app.liliuhuan.armslibrary.di;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.app.liliuhuan.armslibrary.lifecycle.app.AppLifecycles;
import com.app.liliuhuan.armslibrary.di.module.GlobalConfigModule;

import java.util.List;

/**
 * author: 李刘欢
 * date：2018/12/21 14:45
 * version:1.0.0
 * description: ConfigModule  {@link ConfigModule} 可以给框架配置一些参数,需要实现 {@link ConfigModule} 后,在 AndroidManifest 中声明该实现类
 */
public interface ConfigModule {
    /**
     * 使用 {@link GlobalConfigModule.Builder} 给框架配置一些配置参数
     *
     * @param context {@link Context}
     * @param builder {@link GlobalConfigModule.Builder}
     */
    void applyOptions(@NonNull Context context,@NonNull GlobalConfigModule.Builder builder);

    /**
     * 使用 {@link AppLifecycles} 在 {@link Application} 的生命周期中注入一些操作
     *
     * @param context    {@link Context}
     * @param lifecycles {@link Application} 的生命周期容器, 可向框架中添加多个 {@link Application} 的生命周期类
     */
    void injectAppLifecycle(@NonNull Context context, @NonNull List<AppLifecycles> lifecycles);

    /**
     * 使用 {@link Application.ActivityLifecycleCallbacks} 在 {@link Activity} 的生命周期中注入一些操作
     *
     * @param context    {@link Context}
     * @param lifecycles {@link Activity} 的生命周期容器, 可向框架中添加多个 {@link Activity} 的生命周期类
     */
    void injectActivityLifecycle(@NonNull Context context, @NonNull List<Application.ActivityLifecycleCallbacks> lifecycles);

    /**
     * 使用 {@link FragmentManager.FragmentLifecycleCallbacks} 在 {@link Fragment} 的生命周期中注入一些操作
     *
     * @param context    {@link Context}
     * @param lifecycles {@link Fragment} 的生命周期容器, 可向框架中添加多个 {@link Fragment} 的生命周期类
     */
    void injectFragmentLifecycle(@NonNull Context context, @NonNull List<FragmentManager.FragmentLifecycleCallbacks> lifecycles);
}