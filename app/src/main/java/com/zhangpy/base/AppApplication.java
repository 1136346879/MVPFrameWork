package com.zhangpy.base;

import android.app.Application;


import com.hexun.base.common.BaseConfig;
import com.hexun.base.common.CommonBase;
import com.hexun.base.common.NetConfig;
import com.hexun.base.common.RecoveryConfig;
import com.hexun.base.common.ThreadPoolConfig;
import com.hexun.base.ui.RxLifeRecycle;
import com.hexun.base.util.AppUtils;
import com.hexun.base.util.DeviceUtils;
import com.hexun.base.util.Utils;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.MemoryCookieStore;

/**
 * Created by hexun on 2017/9/19.
 */

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initBase();

    }

    private void initBase() {
        Utils.init(this);

        //可选
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor("News");
//        interceptor.setPrintLevel(HttpLoggingInterceptor.Level.HEADERS);
//        interceptor.setColorLevel(Level.INFO);

        //可选
        NetConfig netConfig = new NetConfig.Builder()
                .timeout(30)
                .retry(1)
                .cookieJar(new CookieJarImpl(new MemoryCookieStore()))
                .mode(CacheMode.NO_CACHE)
                .cacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
                .addCommonHeader("AppVersion", AppUtils.getAppVersionName())
                .addCommonHeader("deviceId", DeviceUtils.getAndroidID())
                .addCommonHeader("User-Agent", "")
                .build();

        //可选
        ThreadPoolConfig threadPoolConfig = new ThreadPoolConfig.Builder()
                .corePoolSize(5)
                .maxPoolSize(10)
                .keepAliveTime(120)
                .enableOrderExecutor(true)
                .enableCancelExecutor(true)
                .build();


        //可选
        RecoveryConfig recoveryConfig = new RecoveryConfig.Builder()
                .rootPage(ForwardActivity.class)
                .build();

        //可选
        BaseConfig baseConfig = new BaseConfig.Builder()
                .netConfig(netConfig)
                .recoveryConfig(recoveryConfig)
                .threadPoolConfig(threadPoolConfig)
                .build();

        //必须
        CommonBase.init(this, baseConfig);

        registerActivityLifecycleCallbacks(RxLifeRecycle.get());

    }
}
