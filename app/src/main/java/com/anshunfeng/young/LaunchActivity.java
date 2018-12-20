package com.anshunfeng.young;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.anshunfeng.commom.base.ARouterPath;
import com.anshunfeng.commom.base.TLog;
import com.anshunfeng.commom.base.base.*;
import com.anshunfeng.commom.base.widget.BitmapParticlealSplitView;
import com.anshunfeng.young.contract.LaunchContract;
import com.anshunfeng.young.presenter.LaunchPresenter;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

@Route(path = ARouterPath.LaunchAct)
public class LaunchActivity extends com.anshunfeng.commom.base.base.BaseActivity implements LaunchContract.View{
    private LaunchContract.Presenter presenter=new LaunchPresenter(this);
    @BindView(R.id.btn_time)
    TextView btnTime;
//    @BindView(R.id.welcom_img)
//    BitmapParticlealSplitView welcomeImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_layout);
        ButterKnife.bind(this);
                TLog.log("testbutton",btnTime+"_-");

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(getContentView());
//        ButterKnife.bind(this);
//        TLog.log("testbutton",btnTime+"_-");
//        presenter.startTimer(btnTime);
//
//    }
//
//    @Override
//    public void initView() {
//
//    }

    @Override
    public void endConduct() {
        ARouter.getInstance().build(ARouterPath.TestAct).navigation();
    }
}
