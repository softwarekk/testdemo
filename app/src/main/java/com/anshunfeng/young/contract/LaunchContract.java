package com.anshunfeng.young.contract;

import android.widget.TextView;

import com.anshunfeng.commom.base.base.BasePresenter;
import com.anshunfeng.young.presenter.LaunchPresenter;

/**
 * Created by ${Young} on 2018/11/28.
 */

public interface LaunchContract {
    interface Model {
        void logicConduct(LaunchPresenter presenter,TextView view);
        void endTimer();
    }

    interface View {
        void endConduct();
    }

    interface Presenter extends BasePresenter {
        void startTimer(TextView view);
        void endLogic();
        void clickTimer();
    }
}
