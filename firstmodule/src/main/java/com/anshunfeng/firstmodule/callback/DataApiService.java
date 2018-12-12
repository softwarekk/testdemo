package com.anshunfeng.firstmodule.callback;

import android.view.View;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface DataApiService<T> {


	@GET("api/data/Android/{size}/{index}")
	Observable getAndroidData(@Path("size") String size, @Path("index") String index);
}
