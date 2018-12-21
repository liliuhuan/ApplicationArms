/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.app.liliuhuan.armslibrary.lifecycle;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;


import com.app.liliuhuan.armslibrary.util.RxLifecycleUtils;
import com.trello.rxlifecycle2.RxLifecycle;

import io.reactivex.subjects.Subject;

/**
 * ================================================
 * &#x8ba9; {@link Activity}/{@link Fragment} &#x5b9e;&#x73b0;&#x6b64;&#x63a5;&#x53e3;,&#x5373;&#x53ef;&#x6b63;&#x5e38;&#x4f7f;&#x7528; {@link RxLifecycle}
 * &#x65e0;&#x9700;&#x518d;&#x7ee7;&#x627f; {@link RxLifecycle} &#x63d0;&#x4f9b;&#x7684; Activity/Fragment ,&#x6269;&#x5c55;&#x6027;&#x6781;&#x5f3a;
 *
 * @see RxLifecycleUtils &#x8be6;&#x7ec6;&#x7528;&#x6cd5;&#x8bf7;&#x67e5;&#x770b;&#x6b64;&#x7c7b;
 * Created by JessYan on 25/08/2017 18:39
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface Lifecycleable<E> {
    @NonNull
    Subject<E> provideLifecycleSubject();
}
