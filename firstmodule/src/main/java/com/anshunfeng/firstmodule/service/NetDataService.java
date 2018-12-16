package com.anshunfeng.firstmodule.service;


import com.anshunfeng.firstmodule.bean.GirlsData;
import com.anshunfeng.firstmodule.bean.NewsData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NetDataService {

    @GET  ("api/data/福利/{size}/{index}")
    Observable<GirlsData> getFuliData(@Path("size") String size, @Path("index") String index);
    @GET  ("wxarticle/chapters/json")
    Observable<NewsData> getOfficialList();
}
