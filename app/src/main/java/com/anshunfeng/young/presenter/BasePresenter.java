package com.anshunfeng.young.presenter;

import android.app.Activity;

/**
 * Created by ${Young} on 2018/12/19.
 */
public interface BasePresenter<T>  {
    void attach(Activity mActivity, T mView);
    void dettch();
}
