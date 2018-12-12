package com.anshunfeng.firstmodule;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

//import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.anshunfeng.commom.base.ARouterPath;
import com.anshunfeng.commom.base.BaseActivity;
import com.anshunfeng.commom.base.TLog;
import com.anshunfeng.firstmodule.bean.NewsData;
import com.anshunfeng.firstmodule.entities.GirlsData;
import com.anshunfeng.firstmodule.repository.NetDataRepository;
import com.anshunfeng.firstmodule.service.NetDataService;

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
        TLog.log("testmodule","222");
        NetDataRepository.getFuliDataRepository("20", "1")
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Observer<GirlsData>() {
                      @Override
                      public void onSubscribe(Disposable d) {

                      }

                      @Override
                      public void onNext(GirlsData girlsData) {

                      }

                      @Override
                      public void onError(Throwable e) {
                      }

                      @Override
                      public void onComplete() {
                      }
                  });
    }
}
