package com.anshunfeng.firstmodule.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;
import android.util.Log;

import com.anshunfeng.commom.base.network.NetUtils;
import com.anshunfeng.firstmodule.bean.NewsData;
import com.anshunfeng.firstmodule.repository.NetDataRepository;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ${Young} on 2018/12/12.
 */

public class TestModel extends AndroidViewModel {
    private static final MutableLiveData ABSENT = new MutableLiveData();
    {
        //noinspection unchecked
        ABSENT.setValue(null);
    }
    //生命周期观察的数据
    private LiveData<NewsData> mLiveObservableData;
    //UI使用可观察的数据 ObservableField是一个包装类
//    public ObservableField<NewsData> uiObservableData = new ObservableField<>();
    private final CompositeDisposable mDisposable = new CompositeDisposable();//rxjava2 的水管管理

    public TestModel(@NonNull Application application) {
        super(application);
        mLiveObservableData = Transformations.switchMap(NetUtils.netConnected(application), new android.arch.core.util.Function<Boolean, LiveData<NewsData>>() {
            @Override
            public LiveData<NewsData> apply(Boolean isNetConnected) {

                Log.i("danxx", "apply------>");
                if (!isNetConnected) {
                    return ABSENT; //网络未连接返回空
                }
                final MutableLiveData<NewsData> applyData = new MutableLiveData<>();

                NetDataRepository.getOfficalDataRepository()
                          .subscribeOn(Schedulers.io())
                          .observeOn(AndroidSchedulers.mainThread())
                          .subscribe(new Observer<NewsData>() {
                              @Override
                              public void onSubscribe(Disposable d) {
                                  mDisposable.add(d);
                              }

                              @Override
                              public void onNext(NewsData value) {
                                  applyData.setValue(value);
                              }

                              @Override
                              public void onError(Throwable e) {
                              }

                              @Override
                              public void onComplete() {
                              }
                          });

                return applyData;
            }
        });
    }

    public LiveData<NewsData> getLiveObservableData() {
        return mLiveObservableData;
    }
    /**
     * 设置
     * @param product
     */
    public void setUiObservableData(NewsData product) {
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mDisposable.clear();
    }
}
