package com.anshunfeng.young.http.repository;

import com.anshunfeng.firstmodule.bean.NewsData;
import com.anshunfeng.young.GirlsData;
import com.anshunfeng.young.http.entities.NewRet;

import io.reactivex.Observable;

/**
 * Created by dxx on 2017/11/8.
 */

public class GankDataRepository {

    public static Observable<GirlsData> getFuliDataRepository(String size, String index){

        Observable<GirlsData> observableForGetFuliDataFromNetWork = NewRet.getAndroidData().getFuliData(size,index);

        //可以操作Observable来筛选网络或者是本地数据

        return observableForGetFuliDataFromNetWork;
    }

}
