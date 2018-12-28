package com.zhangpy.base.fragment;

import android.view.View;
import android.widget.Button;

import com.hexun.base.ui.BaseExceptionHandingFragment;
import com.zhangpy.base.R;

/**
 * 作者：    shaoshuai
 * 时间：    2017/10/19 17:18
 * 电子邮箱：
 * 描述:
 */

public class FirstFragment extends BaseExceptionHandingFragment {
    private Button button;

    @Override
    public void initView() {
        button = findView(R.id.btn_first);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showLoadingError();
             onDestroyView();
            }
        });
    }

    @Override
    public int getContentViewResources() {
        return R.layout.fragment_first;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        button.setText("aaaaaaa");
    }
}
