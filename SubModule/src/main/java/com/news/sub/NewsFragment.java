//package com.news.sub;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.alibaba.android.arouter.facade.annotation.Autowired;
//import com.alibaba.android.arouter.facade.annotation.Route;
//import com.alibaba.android.arouter.launcher.ARouter;
//import com.hexun.base.router.RouterSheet;
//
///**
// * @author yangyi 2017年10月19日13:37:01
// */
//@Route(path = RouterSheet.NEWS)
//public class NewsFragment extends Fragment {
//
//    @Autowired
//    String name;
//
//    TextView nameText;
//    private View view;
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ARouter.getInstance().inject(this);
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_news, container, false);
//        return view;
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        nameText = (TextView) view.findViewById(R.id.nameText);
////        nameText.setText(name);
//    }
//}
