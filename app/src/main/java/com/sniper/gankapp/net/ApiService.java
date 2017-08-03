package com.sniper.gankapp.net;

import com.sniper.gankapp.ListData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

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


}
