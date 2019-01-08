package com.anshunfeng.young.presenter;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import com.anshunfeng.commom.base.base.*;
import com.anshunfeng.young.contract.LaunchContract;
import com.anshunfeng.young.model.LaunchModel;

import org.reactivestreams.Subscription;

import java.util.Timer;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by ${Young} on 2018/11/28.
 */

public class LaunchPresenter  implements LaunchContract.Presenter {
    private LaunchContract.View currentView;
    private  LaunchModel model;
    private CompositeDisposable mSubscriptions;
    private Activity mInstance;

    @Override
    public void startTimer() {
        model.logicConduct(this);
    }

    @Override
    public void endLogic() {
        currentView.endConduct();
    }

    @Override
    public void clickTimer() {
        model.endTimer();
    }

    @Override
    public void timerOnTicke(long millisUntilFinished) {
        currentView.onTick(millisUntilFinished);
    }

    @Override
    public void attach(Activity mActivity, LaunchContract.View mView) {
        currentView=mView;
        model = new LaunchModel();
        mInstance=mActivity;
    }

    @Override
    public void dettch() {
        currentView=null;
        model=null;
        mInstance=null;
    }

}
