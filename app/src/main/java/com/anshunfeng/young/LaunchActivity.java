package com.anshunfeng.young;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.anshunfeng.commom.base.ARouterPath;
import com.anshunfeng.commom.base.base.BaseActivity;
import com.anshunfeng.commom.base.TLog;

@Route(path = ARouterPath.LaunchAct)
public class LaunchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TLog.log("testmodule","1111");
        ARouter.getInstance().build( ARouterPath.WebViewAct ).navigation();
    }
}
