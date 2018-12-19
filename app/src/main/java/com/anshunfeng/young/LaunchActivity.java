package com.anshunfeng.young;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.anshunfeng.commom.base.ARouterPath;
import com.anshunfeng.commom.base.TLog;
import com.anshunfeng.commom.base.widget.BitmapParticlealSplitView;
import com.anshunfeng.young.contract.LaunchContract;
import com.anshunfeng.young.presenter.LaunchPresenter;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

@Route(path = ARouterPath.LaunchAct)
public class LaunchActivity extends BaseActivity implements LaunchContract.View{
    private LaunchContract.Presenter presenter=new LaunchPresenter(this);
    @BindView(R.id.time_tv)
    TextView timeTv;
    @BindView(R.id.welcom_img)
    BitmapParticlealSplitView welcomImg;
    @Override
    public int getContentView() {
        return R.layout.launch_layout;
    }


    @Override
    public void initView() {
        presenter.startTimer();
    }

    @Override
    public void endConduct() {

    }
}
