package com.app.liliuhuan.applicationarms.di.component;

import dagger.Component;

import com.app.liliuhuan.armslibrary.di.component.AppComponent;
import com.app.liliuhuan.armslibrary.di.scope.ActivityScope;


import com.app.liliuhuan.applicationarms.di.module.MainModule;

import com.app.liliuhuan.applicationarms.mvp.ui.activity.MainActivity;

@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}