package com.app.liliuhuan.applicationarms.mvp.presenter;

import android.app.Application;



import me.jessyan.rxerrorhandler.core.RxErrorHandler;

import javax.inject.Inject;

import com.app.liliuhuan.applicationarms.mvp.contract.MainContract;
import com.app.liliuhuan.armslibrary.AppManager;
import com.app.liliuhuan.armslibrary.di.scope.ActivityScope;
import com.app.liliuhuan.armslibrary.http.imageloader.ImageLoader;
import com.app.liliuhuan.armslibrary.mvp.presenter.BasePresenter;


@ActivityScope
public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public MainPresenter(MainContract.Model model, MainContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }
}
