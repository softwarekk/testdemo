/*
 * Copyright 2018 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.anshunfeng.young.librarymodule.autosize;

import android.app.Activity;
import android.app.Application;


import com.anshunfeng.young.librarymodule.autosize.external.ExternalAdaptInfo;
import com.anshunfeng.young.librarymodule.autosize.internal.CancelAdapt;
import com.anshunfeng.young.librarymodule.autosize.internal.CustomAdapt;
import com.anshunfeng.young.librarymodule.autosize.utils.LogUtils;

import java.util.Locale;

/**
 * ================================================
 * 屏幕适配逻辑策略默认实现类, 可通过 {@link AutoSizeConfig#init(Application, boolean, AutoAdaptStrategy)}
 * 和 {@link AutoSizeConfig#setAutoAdaptStrategy(AutoAdaptStrategy)} 切换策略
 *
 * @see AutoAdaptStrategy
 * Created by JessYan on 2018/8/9 15:57
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class DefaultAutoAdaptStrategy implements AutoAdaptStrategy {
    @Override
    public void applyAdapt(Activity activity) {

        //检查是否开启了外部三方库的适配模式, 只要不主动调用 ExternalAdaptManager 的方法, 下面的代码就不会执行
        if (AutoSizeConfig.getInstance().getExternalAdaptManager().isRun()) {
            if (AutoSizeConfig.getInstance().getExternalAdaptManager().isCancelAdapt(activity.getClass())) {
                LogUtils.w(String.format(Locale.ENGLISH, "%s canceled the adaptation!", activity.getClass().getName()));
                AutoSize.cancelAdapt(activity);
                return;
            } else {
                ExternalAdaptInfo info = AutoSizeConfig.getInstance().getExternalAdaptManager()
                        .getExternalAdaptInfoOfActivity(activity.getClass());
                if (info != null) {
                    LogUtils.d(String.format(Locale.ENGLISH, "%s used %s for adaptation!", activity.getClass().getName(), ExternalAdaptInfo.class.getName()));
                    AutoSize.autoConvertDensityOfExternalAdaptInfo(activity, info);
                    return;
                }
            }
        }

        //如果 activity 实现 CancelAdapt 接口表示放弃适配, 所有的适配效果都将失效
        if (activity instanceof CancelAdapt) {
            LogUtils.w(String.format(Locale.ENGLISH, "%s canceled the adaptation!", activity.getClass().getName()));
            AutoSize.cancelAdapt(activity);
            return;
        }

        //如果 activity 实现 CustomAdapt 接口表示该 activity 想自定义一些用于适配的参数, 从而改变最终的适配效果
        if (activity instanceof CustomAdapt) {
            LogUtils.d(String.format(Locale.ENGLISH, "%s implemented by %s!", activity.getClass().getName(), CustomAdapt.class.getName()));
            AutoSize.autoConvertDensityOfCustomAdapt(activity, (CustomAdapt) activity);
        } else {
            LogUtils.d(String.format(Locale.ENGLISH, "%s used the global configuration.", activity.getClass().getName()));
            AutoSize.autoConvertDensityOfGlobal(activity);
        }
    }
}
