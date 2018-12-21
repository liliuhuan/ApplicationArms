package com.app.liliuhuan.armslibrary.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.app.liliuhuan.armslibrary.di.ConfigModule;

import java.util.ArrayList;
import java.util.List;

/**
 * author: 李刘欢
 * date：2018/12/21 14:44
 * version:1.0.0
 * description: ManifestParser   用于解析 AndroidManifest 中的 Meta 属性  配合 {@link ConfigModule} 使用
 */
public class ManifestParser {
    private static final String MODULE_VALUE = "ConfigModule";
    private final Context mContext;

    public ManifestParser(Context mContext) {
        this.mContext = mContext;
    }

    public List<ConfigModule> parse() {
        List<ConfigModule> modules = new ArrayList<>();
        try {
            ApplicationInfo appInfo = mContext.getPackageManager().getApplicationInfo(mContext.getPackageName(), PackageManager.GET_META_DATA);
            if (null != appInfo.metaData) {
                for (String key : appInfo.metaData.keySet()) {
                    if (MODULE_VALUE.equals(appInfo.metaData.get(key))) {
                        modules.add(parseModule(key));
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Unable to find metadata to parse ConfigModule", e);
        }

        return modules;
    }

    private static ConfigModule parseModule(String className) {
        Class<?> clazz;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Unable to find ConfigModule implementation", e);
        }
        Object module;
        try {
            module = clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("Unable to instantiate ConfigModule implementation for " + clazz, e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to instantiate ConfigModule implementation for " + clazz, e);
        }

        if (!(module instanceof ConfigModule)) {
            throw new RuntimeException("Expected instanceof ConfigModule, but found: " + module);
        }
        return (ConfigModule) module;
    }
}