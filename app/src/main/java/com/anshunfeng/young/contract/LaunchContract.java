package com.anshunfeng.young.contract;

import android.widget.TextView;

import com.anshunfeng.young.presenter.BasePresenter;
import com.anshunfeng.young.presenter.LaunchPresenter;

/**
 * Created by ${Young} on 2018/11/28.
 */

public interface LaunchContract {
    interface Model {
        void logicConduct(LaunchPresenter presenter);
        void endTimer();
    }

    interface View {//如有需要继承baseview 实现基本功能
        void endConduct();
        void onTick(long millisUntilFinished);
    }

    interface Presenter extends  BasePresenter<View>{
        void startTimer();
        void endLogic();
        void clickTimer();
        void timerOnTicke(long millisUntilFinished);
    }
}
