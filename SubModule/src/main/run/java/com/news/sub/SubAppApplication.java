package com.news.sub;

import android.app.Application;

import com.hexun.base.*;
import com.hexun.base.util.AppUtils;
import com.hexun.base.util.DeviceUtils;
import com.hexun.base.util.Utils;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.MemoryCookieStore;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import okhttp3.OkHttpClient;

/**
 * Created by hexun on 2017/9/19.
 */

public class SubAppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initBase();
    }

    private void initBase() {
        Utils.init(this);

        NetConfig netConfig = new NetConfig.Builder()
                .timeout(30)
                .retry(1)
                .cookieJar(new CookieJarImpl(new MemoryCookieStore()))
                .mode(CacheMode.NO_CACHE)
                .cacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
                .interceptor(null)
                .addCommonHeader("AppVersion", AppUtils.getAppVersionName())
                .addCommonHeader("deviceId", DeviceUtils.getAndroidID())
                .addCommonHeader("User-Agent", "")
                .build();

        BaseConfig baseConfig = new BaseConfig.Builder()
                .netConfig(netConfig)
                .build();


        CommonBase.INSTANCE.init(this, baseConfig);
    }
}
