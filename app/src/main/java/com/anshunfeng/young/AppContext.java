package com.anshunfeng.young;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.anshunfeng.commom.base.BaseActivity;
import com.anshunfeng.commom.base.BaseApplication;
import com.anshunfeng.commom.base.TLog;
import com.anshunfeng.commom.base.Utils;

/**
 * Created by ${Young} on 2018/11/29.
 */

public class AppContext extends BaseApplication {
//    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
    }
    private void initARouter() {
        if(Utils.isAppDebug()){
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}
