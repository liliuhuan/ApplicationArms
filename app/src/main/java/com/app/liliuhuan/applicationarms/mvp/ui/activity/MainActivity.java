package com.app.liliuhuan.applicationarms.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


import com.app.liliuhuan.applicationarms.di.component.DaggerMainComponent;
import com.app.liliuhuan.applicationarms.di.module.MainModule;
import com.app.liliuhuan.applicationarms.mvp.contract.MainContract;
import com.app.liliuhuan.applicationarms.mvp.presenter.MainPresenter;

import com.app.liliuhuan.applicationarms.R;
import com.app.liliuhuan.armslibrary.base.BaseActivity;
import com.app.liliuhuan.armslibrary.di.component.AppComponent;
import com.app.liliuhuan.armslibrary.util.ArmsUtils;

import static com.app.liliuhuan.armslibrary.util.Preconditions.checkNotNull;


public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }
}
