package com.zhangpy.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.ALog;
import com.hexun.base.common.CommonBase;
import com.hexun.base.common.Priority;
import com.hexun.base.common.RxTask;
import com.hexun.base.common.Task;
import com.hexun.base.router.RouterSheet;
import com.hexun.base.ui.BaseTitleBarActivity;

import static com.hexun.base.router.RouterSheet.SUB;

public class ForwardActivity extends BaseTitleBarActivity {

    private Button forward, forwardSecond, forwardThird, forwardMain, night;


    @Override
    public void initView() {
        forward = (Button) findViewById(R.id.forward);
        forwardSecond = (Button) findViewById(R.id.forward_second);
        forwardThird = (Button) findViewById(R.id.forward_third);
        forwardMain = (Button) findViewById(R.id.forward_main);
        night = (Button) findViewById(R.id.night);
    }

    @Override
    public void initData() {
        executeTask(new Task(Priority.DEFAULT) {
            @Override
            public void run() {

            }
        });

        runRxTask(new RxTask<Void>() {
            @Override
            public Void run() {
                ALog.d("RxRun");
                return null;
            }
        });
    }

    @Override
    public void initListener() {
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/base/TestBaseActivity").navigation(ForwardActivity.this, new NavigationCallback() {
                    @Override
                    public void onFound(Postcard postcard) {
                        Toast.makeText(ForwardActivity.this, "找到该页面", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        Toast.makeText(ForwardActivity.this, "没有找到该页面", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                        Toast.makeText(ForwardActivity.this, "到达该页面", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        Toast.makeText(ForwardActivity.this, "没有找到该页面", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        forwardSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/app/SecondActivity").navigation(ForwardActivity.this, new NavigationCallback() {
                    @Override
                    public void onFound(Postcard postcard) {
                        Toast.makeText(ForwardActivity.this, "找到该页面", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        Toast.makeText(ForwardActivity.this, "没有找到该页面", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                        Toast.makeText(ForwardActivity.this, "到达该页面", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        Toast.makeText(ForwardActivity.this, "没有找到该页面", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        forwardThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(SUB).navigation();
            }
        });

        forwardMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(RouterSheet.MAIN).navigation();
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
        return R.layout.activity_forward;
    }
}
