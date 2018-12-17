package com.anshunfeng.young;

import com.alibaba.android.arouter.launcher.ARouter;
import com.anshunfeng.commom.base.base.BaseApplication;
import com.anshunfeng.commom.base.Utils;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by ${Young} on 2018/11/29.
 */

public class AppContext extends BaseApplication {
//    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
        Fresco.initialize(this);
    }
    private void initARouter() {
        if(Utils.isAppDebug()){
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}
