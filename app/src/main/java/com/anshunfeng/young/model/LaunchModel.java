package com.anshunfeng.young.model;

import android.os.CountDownTimer;
import android.widget.TextView;

import com.anshunfeng.young.contract.LaunchContract;
import com.anshunfeng.young.presenter.LaunchPresenter;

/**
 * Created by ${Young} on 2018/11/28.
 */

public class LaunchModel implements LaunchContract.Model {
    private TextView timeTv;
    private LaunchPresenter presenter;
    private MyCountDownTimer countDownTimer;

    @Override
    public void logicConduct(LaunchPresenter presenter, TextView timeTv) {
        this.timeTv=timeTv;
        this.presenter=presenter;
        countDownTimer = new MyCountDownTimer(3000, 1000);
        countDownTimer.start();
    }

    @Override
    public void endTimer() {
        countDownTimer.cancel();
        presenter.endLogic();
    }


    class MyCountDownTimer extends CountDownTimer {//倒计时
        /**
         * @param millisInFuture
         * 表示以毫秒为单位 倒计时的总数
         * 例如 millisInFuture=1000 表示1秒
         * @param countDownInterval
         * 表示 间隔 多少微秒 调用一次 onTick 方法
         * 例如: countDownInterval =1000 ; 表示每1000毫秒调用一次onTick()
         */
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        public void onFinish() {
            timeTv.setText("跳过\n0s");
            presenter.endLogic();
        }
        public void onTick(long millisUntilFinished) {
            timeTv.setText("跳过\n" + millisUntilFinished / 1000 + "s");
        }
    }

}
