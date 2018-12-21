package com.app.liliuhuan.armslibrary.http.url;

import android.support.annotation.NonNull;

import okhttp3.HttpUrl;

/**
 * 针对于 BaseUrl 在 App 启动时不能确定,需要请求服务器接口动态获取的应用场景
 * <p>
 * author: 李刘欢
 * date：2018/12/21 16:09
 * version:1.0.0
 * description: BaseUrl
 */
public interface BaseUrl {
    /**
     * 在调用 Retrofit API 接口之前,使用 Okhttp 或其他方式,请求到正确的 BaseUrl 并通过此方法返回
     *
     * @return
     */
    @NonNull
    HttpUrl url();
}
