package com.zhangpy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;

import static com.hexun.base.router.RouterSheet.SECOND;

/**
 * Created by hexun on 2017/9/20.
 */
@Route(path = SECOND)
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
