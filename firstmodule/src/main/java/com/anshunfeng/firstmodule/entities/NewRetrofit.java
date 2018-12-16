package com.anshunfeng.firstmodule.entities;


import com.anshunfeng.commom.base.network.ApiClient;
import com.anshunfeng.commom.base.network.ApiConstants;
import com.anshunfeng.firstmodule.service.NetDataService;

/**
 * Created by ${Young} on 2018/11/30.
 */

public class NewRetrofit {
    public static NetDataService getAndroidData(){

        NetDataService androidData = ApiClient.initService(ApiConstants.Wanandroid, NetDataService.class);

        return androidData;
    }
}
