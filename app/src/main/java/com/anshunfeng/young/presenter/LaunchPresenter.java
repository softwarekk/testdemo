package com.anshunfeng.young.presenter;

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

public class LaunchPresenter implements LaunchContract.Presenter {
    private LaunchContract.View mView;
    private final LaunchModel model;
    private CompositeDisposable mSubscriptions;

    public LaunchPresenter(LaunchContract.View androidView){
        mView=androidView;
        model = new LaunchModel();
        mSubscriptions=new CompositeDisposable();

    }


    @Override
    public void startTimer(TextView view) {
        model.logicConduct(this,view);
    }

    @Override
    public void endLogic() {
        mView.endConduct();
    }

    @Override
    public void clickTimer() {
        model.endTimer();
    }


    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {
        if(mSubscriptions.isDisposed()){
            mSubscriptions.clear();
        }
    }
}
