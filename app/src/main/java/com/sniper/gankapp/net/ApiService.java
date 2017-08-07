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
福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
    */

    @GET("data/all/{size}/{page}")
    Observable<Response> listAll(@Path("size") int size, @Path("page") int page);

    @GET("data/福利/{size}/{page}")
    Observable<Response> listFuli(@Path("size") int size, @Path("page") int page);

    @GET("data/Android/{size}/{page}")
    Observable<Response> listAndroid(@Path("size") int size, @Path("page") int page);

    @GET("data/iOS/{size}/{page}")
    Observable<Response> listiOS(@Path("size") int size, @Path("page") int page);

    @GET("data/休息视频/{size}/{page}")
    Observable<Response> listShiPing(@Path("size") int size, @Path("page") int page);

    @GET("data/拓展资源/{size}/{page}")
    Observable<Response> listTuoZhan(@Path("size") int size, @Path("page") int page);

    @GET("data/前端/{size}/{page}")
    Observable<Response> listQianDuan(@Path("size") int size, @Path("page") int page);


}
