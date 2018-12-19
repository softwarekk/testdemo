package com.anshunfeng.young.contract;

import com.anshunfeng.young.presenter.BasePresenter;
import com.anshunfeng.young.presenter.LaunchPresenter;

/**
 * Created by ${Young} on 2018/11/28.
 */

public interface LaunchContract {
    interface Model {
        void logicConduct(LaunchPresenter presenter);
    }

    interface View {
        void endConduct();
    }

    interface Presenter extends BasePresenter {
        void startTimer();
        void endLogic();
    }
}
