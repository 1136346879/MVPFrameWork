package com.zhangpy.base;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
//import android.support.annotation.Nullable;
import android.widget.LinearLayout;

//import com.alibaba.android.arouter.facade.annotation.Route;
//import com.blankj.ALog;
//import com.bumptech.glide.Glide;
//import com.hexun.base.imageLoad.GlideApp;
//import com.hexun.base.imageLoad.ImageLoader;
//import com.hexun.base.ui.RxCancelActivity;
//import com.hexun.base.ui.RxLifeRecycle;
//import com.hexun.base.ui.RxTransformer;
//
//import java.util.concurrent.TimeUnit;
//
//import io.reactivex.Observable;
//import io.reactivex.disposables.Disposable;
//import io.reactivex.functions.Consumer;

/**
 * 作者：    shaoshuai
 * 时间：    2017/10/23 10:41
 * 电子邮箱：
 * 描述:
 */
//@Route(path = "/test/TestRxBaseActivity")
public class TestRxBaseActivity extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.RED);
        setContentView(layout);
        init();
    }

    private void init() {
//        Observable.interval(1, TimeUnit.SECONDS).doOnSubscribe(RxLifeRecycle.get().canCancel()).subscribe(new Consumer<Long>() {
//            @Override
//            public void accept(Long integer) throws Exception {
//                ALog.e("打印页面结束是否取消订阅--->", integer);
//            }
//        });
//        Glide.with(this);
    }
}
