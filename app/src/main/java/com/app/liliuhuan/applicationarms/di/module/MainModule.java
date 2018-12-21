package com.app.liliuhuan.applicationarms.di.module;



import dagger.Module;
import dagger.Provides;

import com.app.liliuhuan.applicationarms.mvp.contract.MainContract;
import com.app.liliuhuan.applicationarms.mvp.model.MainModel;
import com.app.liliuhuan.armslibrary.di.scope.ActivityScope;


@Module
public class MainModule {
    private MainContract.View view;

    /**
     * 构建MainModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MainContract.View provideMainView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MainContract.Model provideMainModel(MainModel model) {
        return model;
    }
}