package com.anshunfeng.firstmodule;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.BindingMethod;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.anshunfeng.commom.base.ARouterPath;
import com.anshunfeng.commom.base.BaseActivity;
import com.anshunfeng.commom.base.TLog;
import com.anshunfeng.commom.base.network.SwitchSchedulers;
import com.anshunfeng.firstmodule.adapter.TestAdaper;
import com.anshunfeng.firstmodule.bean.GirlsData;
import com.anshunfeng.firstmodule.bean.NewsData;
import com.anshunfeng.firstmodule.repository.NetDataRepository;
import com.anshunfeng.firstmodule.viewmodel.TestModel;
import com.anshunfeng.young.firstmoudle.R;
import com.anshunfeng.young.firstmoudle.databinding.TestLayoutBinding;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ${Young} on 2018/11/29.
 */
@Route(path =ARouterPath.TestAct)
public class TestActivity  extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TLog.log("testactivity111");
        TestLayoutBinding testDinding=DataBindingUtil.setContentView(TestActivity.this, R.layout.test_layout);
        final TestModel testModel =
                  ViewModelProviders.of(this).get(TestModel.class);
        final TestAdaper adaper=new TestAdaper();

        testDinding.setTestAdapter(adaper);
        //观察数据变化来刷新UI
        testModel.getLiveObservableData().observe(this, new android.arch.lifecycle.Observer<NewsData>() {
            @Override
            public void onChanged(@Nullable NewsData newsData) {
                TLog.log("testnewdta",newsData.getData().get(0).getName());
                testModel.setUiObservableData(newsData);
                adaper.setTestList(newsData.getData());
            }
        });
    }
}
