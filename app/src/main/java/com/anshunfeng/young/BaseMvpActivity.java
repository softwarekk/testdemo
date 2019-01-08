package com.anshunfeng.young;

import android.os.Bundle;

import com.anshunfeng.commom.base.base.BaseActivity;
import com.anshunfeng.young.presenter.BasePresenter;

/**
 * Created by ${Young} on 2018/12/21.
 */

public abstract  class BaseMvpActivity<V,T extends BasePresenter> extends BaseActivity {
    //需要啥自己封装

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
