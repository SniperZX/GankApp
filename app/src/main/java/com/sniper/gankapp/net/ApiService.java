package com.sniper.gankapp.net;

import com.sniper.gankapp.ListData;
import com.sniper.gankapp.data.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by zhaohongru on 2017-08-03.
 * PackageName: com.sniper.gankapp.net.ApiService
 * Description：构造api接口
 */
public interface ApiService {

    public static final String base_url = "http://gank.io/api/";

    //http://gank.io/api/data/Android/10/1
    @GET("data/Android/{size}/{page}")
    Observable<ListData> list(@Path("size") int size, @Path("page") int page);
/*
    分类查询
    http://gank.io/api/data/Android/10/1
    http://gank.io/api/data/福利/10/1
    http://gank.io/api/data/iOS/20/2
    http://gank.io/api/data/all/20/2

    */

    @GET("data/all/{size}/{page}")
    Observable<Response> listAll(@Path("size") int size, @Path("page") int page);


}
