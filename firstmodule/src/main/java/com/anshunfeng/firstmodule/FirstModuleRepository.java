package com.anshunfeng.firstmodule;

import com.anshunfeng.firstmodule.bean.NewsData;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

/**
 * Created by ${Young} on 2018/11/30.
 */

public class FirstModuleRepository {
    public static Observable<NewsData> getNewsDataRepository(String size, String index){

        Observable<NewsData> obv = RetrofitEntities.getDynamicDataService().getAndroidData(size,index);

        //可以操作Observable来筛选网络或者是本地数据

        return obv;
    }

}
