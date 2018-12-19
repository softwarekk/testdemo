package com.anshunfeng.young.model;

import com.anshunfeng.young.contract.LaunchContract;
import com.anshunfeng.young.presenter.LaunchPresenter;

/**
 * Created by ${Young} on 2018/11/28.
 */

public class LaunchModel implements LaunchContract.Model {

    @Override
    public void logicConduct(LaunchPresenter presenter) {
        

        presenter.endLogic();

    }
}
