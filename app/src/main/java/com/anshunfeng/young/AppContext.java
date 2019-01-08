package com.anshunfeng.young;

import android.app.Activity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.anshunfeng.commom.base.base.BaseApplication;
import com.anshunfeng.commom.base.Utils;
import com.anshunfeng.young.librarymodule.CustomActivityOnCrash;
import com.anshunfeng.young.librarymodule.autosize.AutoSizeConfig;
import com.anshunfeng.young.librarymodule.autosize.external.ExternalAdaptInfo;
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
        initAutoSize();
        CustomActivityOnCrash.install(this);
    }

    private void initAutoSize() {
        AutoSizeConfig.getInstance()
                  .setLog(true)
                  .setUseDeviceSize(true)
                  .setBaseOnWidth(false);
    }

    private void initARouter() {
        if(Utils.isAppDebug()){
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
//    private void customAdaptForExternal(Activity instance) {
        //第三方页面  addCancelAdaptOfActivity 取消适配  addExternalAdaptInfoOfActivity 自定义适配
//        AutoSizeConfig.getInstance().getExternalAdaptManager()
    //                .addCancelAdaptOfActivity(DefaultErrorActivity.class)

//                  .addExternalAdaptInfoOfActivity(DefaultErrorActivity.class, new ExternalAdaptInfo(true, 400));
//    }

}
