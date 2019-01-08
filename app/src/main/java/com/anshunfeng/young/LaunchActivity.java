package com.anshunfeng.young;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.anshunfeng.commom.base.ARouterPath;
import com.anshunfeng.commom.base.base.BaseActivity;
import com.anshunfeng.commom.base.widget.BitmapParticlealSplitView;
import com.anshunfeng.commom.base.widget.BitmapTXTSplitView;
import com.anshunfeng.young.contract.LaunchContract;
import com.anshunfeng.young.presenter.*;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = ARouterPath.LaunchAct)
public class LaunchActivity extends BaseActivity implements LaunchContract.View{
    private LaunchContract.Presenter presenter=new LaunchPresenter();
    @BindView(R.id.btn_time)
    TextView btnTime;
    @BindView(R.id.welcom_img)
    BitmapTXTSplitView welcomeImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_layout);
        ButterKnife.bind(this);
        presenter.attach(this,this);
        initView();
    }

    private void initView() {
        presenter.startTimer();
    }

    @Override
    public void endConduct() {
        btnTime.setText("跳过\n0s");
        ARouter.getInstance().build(ARouterPath.TestAct).navigation();
        finish();
    }

    @Override
    public void onTick(long millisUntilFinished) {
        btnTime.setText("跳过\n" + millisUntilFinished / 1000 + "s");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettch();
    }
}
