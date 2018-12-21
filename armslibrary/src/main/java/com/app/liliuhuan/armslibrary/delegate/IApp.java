package com.app.liliuhuan.armslibrary.delegate;

import android.support.annotation.NonNull;

import com.app.liliuhuan.armslibrary.di.component.AppComponent;

/**
 * author: 李刘欢
 * date：2018/12/21 14:30
 * version:1.0.0
 * description: IApp  框架要求框架中的每个 {@link android.app.Application} 都需要实现此类, 以满足规范
 */
public interface IApp {

    @NonNull
    AppComponent getAppComponent();
}
