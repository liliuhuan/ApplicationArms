package com.app.liliuhuan.armslibrary.lifecycle.app;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * author: 李刘欢
 * date：2018/12/21 14:38
 * version:1.0.0
 * description: AppLifecycles   用于代理 {@link Application} 的生命周期
 */
public interface AppLifecycles {
    void attachBaseContext(@NonNull Context base);

    void onCreate(@NonNull Application application);

    void onTerminate(@NonNull Application application);
}
