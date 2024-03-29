package com.anshunfeng.commom.base.base;

import android.app.Application;


import com.anshunfeng.commom.base.ApplicationDelegate;
import com.anshunfeng.commom.base.TLog;
import com.anshunfeng.commom.base.Utils;

import java.util.List;


/**
 * 要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication；
 * 组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件的Application需置于java/debug文件夹中，不得放于主代码；
 * 组件中获取Context的方法必须为:Utils.getContext()，不允许其他写法；
 * @name BaseApplication
 */
public class BaseApplication extends Application {



    private static BaseApplication sInstance;

    private List<ApplicationDelegate> mAppDelegateList;


    public static BaseApplication getIns() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        TLog.log("application11","111");
        sInstance = this;
        Utils.init(this);
//        Logger.init("pattern").logLevel(LogLevel.FULL);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
//        for (ApplicationDelegate delegate : mAppDelegateList) {
//            delegate.onTerminate();
//        }
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
//        for (ApplicationDelegate delegate : mAppDelegateList) {
//            delegate.onLowMemory();
//        }
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
//        for (ApplicationDelegate delegate : mAppDelegateList) {
//            delegate.onTrimMemory(level);
//        }
    }
}
