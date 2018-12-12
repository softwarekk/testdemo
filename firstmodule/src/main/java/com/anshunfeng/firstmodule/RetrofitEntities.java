package com.anshunfeng.firstmodule;

import com.anshunfeng.commom.base.network.ApiClient;
import com.anshunfeng.commom.base.network.ApiConstants;
import com.anshunfeng.firstmodule.callback.DataApiService;


/**
 * Created by ${Young} on 2018/11/30.
 */

public class RetrofitEntities {
    public static DataApiService getDynamicDataService(){

        DataApiService androidData = ApiClient.initService(ApiConstants.GankHost, DataApiService.class);

        return androidData;
    }
}
