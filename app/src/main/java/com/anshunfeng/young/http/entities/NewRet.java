package com.anshunfeng.young.http.entities;


import com.anshunfeng.commom.base.network.ApiClient;
import com.anshunfeng.commom.base.network.ApiConstants;
import com.anshunfeng.young.http.service.GankDataService;

/**
 * Created by ${Young} on 2018/11/30.
 */

public class NewRet {
    public static GankDataService getAndroidData(){

        GankDataService androidData = ApiClient.initService(ApiConstants.GankHost, GankDataService.class);

        return androidData;
    }
}
