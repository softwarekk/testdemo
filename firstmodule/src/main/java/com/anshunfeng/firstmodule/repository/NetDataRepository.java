package com.anshunfeng.firstmodule.repository;


import com.anshunfeng.firstmodule.bean.GirlsData;
import com.anshunfeng.firstmodule.bean.NewsData;
import com.anshunfeng.firstmodule.entities.NewRetrofit;

import io.reactivex.Observable;


public class NetDataRepository {

    public static Observable<GirlsData> getFuliDataRepository(String size, String index){

        Observable<GirlsData> observableForGetFuliDataFromNetWork = NewRetrofit.getAndroidData().getFuliData(size,index);

        //可以操作Observable来筛选网络或者是本地数据

        return observableForGetFuliDataFromNetWork;
    }

    public static Observable<NewsData> getOfficalDataRepository(){

        Observable<NewsData> observableOfficalDataRepository = NewRetrofit.getAndroidData().getOfficialList();

        return observableOfficalDataRepository;
    }

}
