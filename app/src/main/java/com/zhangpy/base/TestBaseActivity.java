package com.zhangpy.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.ALog;
import com.hexun.base.rx.RxSubscriber;
import com.hexun.base.ui.BaseTitleBarActivity;
import com.hexun.base.ui.RxTransformer;
import com.hexun.base.ui.adapter.SampleDefaultAdapter;
import com.hexun.base.util.DialogUtils;
import com.news.extend.DebugLog;
import com.zhangpy.base.fragment.FirstFragment;
import com.zhangpy.base.fragment.SecondFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * 作者：    shaoshuai
 * 时间：    2017/10/18 10:33
 * 电子邮箱：
 * 描述:
 */
@Route(path = "/base/TestBaseActivity")
public class TestBaseActivity extends BaseTitleBarActivity {
    private Button btn;
    private ViewPager pager;
    private List<Fragment> fragments;


    @Override
    public void initView() {
//        SampleDefaultAdapter sampleDefaultAdapter = new SampleDefaultAdapter(this, "this is title");
//        sampleDefaultAdapter.getConfig().backGroundColor(Color.CYAN).textColor(Color.WHITE).backGround(R.drawable.ic_recovery_page);
//        setTitleAdapter(sampleDefaultAdapter);
        setSampleTitle("this is test", false);
        SampleDefaultAdapter adapter = getSampleDefaultTitleAdapter();
        adapter.getConfig().backGroundColor(Color.CYAN).textColor(Color.WHITE);
        notifyTitleChange();
        btn = findView(R.id.btn);
        pager = findView(R.id.vp);

    }

    @DebugLog
    @Override
    public void initData() {
        fragments = new ArrayList<>();
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());
        pager.setAdapter(new MyViewPager(getSupportFragmentManager()));
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "333333");
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        test(map, list, "aa", "BBBBB", new Integer[]{3, 5});
//        testDestroy();
    }

    @DebugLog
    private <V, K> List<String> test(Map<? super K, V> map, List<? extends Integer> lists, String test, V t, K[] ks) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            test = test + i;
            strings.add(test);
        }
        return strings;
    }

    private void testDestroy() {
        Observable.interval(1, TimeUnit.SECONDS).subscribe(new RxSubscriber<Long>() {
            @Override
            public void onStart(@NonNull Disposable d) {
                addDisposables(d);
                ALog.e("打印方法--->onStart");
            }

            @Override
            public void onData(@io.reactivex.annotations.Nullable Long item) {
                ALog.e("打印页面结束是否取消订阅--->", item);
            }

            @Override
            public void onError(int code, Throwable e) {

            }

            @Override
            public void onDone() {

            }
        });
    }


    @Override
    public void initListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/test/TestRxBaseActivity").navigation();
//                showLoadingError();
//                DialogUtils.get(TestBaseActivity.this).title("标题").titleColor(Color.BLUE).content("content").positive("取消").build().showDialog();
            }
        });
    }

    @Override
    public int getContentViewResources() {
        return R.layout.test_base_activity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setFullScreen();
        super.onCreate(savedInstanceState);
    }

    class MyViewPager extends FragmentPagerAdapter {

        public MyViewPager(FragmentManager fm) {
            super(fm);
        }

        @DebugLog
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
