package com.app.liliuhuan.applicationarms.mvp.model;

import android.app.Application;

import com.app.liliuhuan.armslibrary.di.scope.ActivityScope;
import com.app.liliuhuan.armslibrary.http.repository.IRepositoryManager;
import com.app.liliuhuan.armslibrary.mvp.model.BaseModel;
import com.google.gson.Gson;


import javax.inject.Inject;

import com.app.liliuhuan.applicationarms.mvp.contract.MainContract;


@ActivityScope
public class MainModel extends BaseModel implements MainContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public MainModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}