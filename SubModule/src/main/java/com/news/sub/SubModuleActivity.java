package com.news.sub;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.ALog;
import com.hexun.base.common.CommonBase;
import com.hexun.base.rx.RxSubscriber;
import com.hexun.base.ui.BaseTitleBarActivity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

import static com.hexun.base.router.RouterSheet.SUB;


/**
 * Created by hexun on 2017/9/19.
 */
@Route(path = SUB)
public class SubModuleActivity extends BaseTitleBarActivity {

    Button crash, night;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {
        crash = (Button) findViewById(R.id.crash);
        night = (Button) findViewById(R.id.night);
    }

    @Override
    public void initData() {
        SubModuleApi.getRecommendData()
                .subscribe(new RxSubscriber<List<Article>>() {

                    @Override
                    public void onStart(@NonNull Disposable d) {
                        addDisposables(d);
                    }

                    @Override
                    public void onData(@Nullable List<Article> item) {
                        if (item == null){
                            return;
                        }
                        ALog.d(item);
                    }

                    @Override
                    public void onError(int code, Throwable e) {
                        ALog.d(e.toString());
                    }

                    @Override
                    public void onDone() {
                        ALog.d("complete");
                    }
                });
    }

    @Override
    public void initListener() {
        crash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = 10 / 0;
            }
        });
        night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonBase.getConfig().switchDayNight();
            }
        });
    }

    @Override
    public int getContentViewResources() {
        return R.layout.activity_stub_module;
    }
}
