package com.zhangpy.base;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;

/**
 * Created by hexun on 2017/9/20.
 */

@Route(path = "/xxx/xxx")
public class Degrade implements DegradeService {

    private Context app;

    @Override
    public void onLost(Context context, Postcard postcard) {
        Toast.makeText(app,"全局降级,未找到",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {
        app = context;
    }
}
