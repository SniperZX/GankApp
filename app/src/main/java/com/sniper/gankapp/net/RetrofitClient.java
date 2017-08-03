package com.sniper.gankapp.net;

import android.content.Context;
import android.text.TextUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhaohongru on 2017-08-03.
 * PackageName: com.sniper.gankapp.net.RetrofitClient
 * Description：构建retrofit客户端
 */
public class RetrofitClient {
    public static final int TIME_OUT = 5;

    private ApiService apiService;
    private OkHttpClient okHttpClient;
    private static RetrofitClient sNewInstance;//多一个实例，用于不同于baseurl的请求
    private static Context mContext;
    private static final String CACHE_PATH="gankCache";
    private static final int CACHE_SIZE=1024*1024*30;

    private static class SingletonHolder {
        //这个好处在于不用每次都要判断是否初始化过，直接使用即可
        private static RetrofitClient INSTANCE = new RetrofitClient(mContext);
    }

    private RetrofitClient(Context context){

        //构造函数
        this(context, null);

    }

    public ApiService getService(){
        return  apiService;
    }

    private RetrofitClient(Context context,String url) {
        if(TextUtils.isEmpty(url)){
            url = ApiService.base_url;
        }

        File file = new File(context.getCacheDir(), CACHE_PATH);
        Cache cache = new Cache(file,CACHE_SIZE);
        okHttpClient = new OkHttpClient.Builder()
             //  .addInterceptor(new CacheInterceptor(cache))

                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        apiService = retrofit.create(ApiService.class);


    }

    public static RetrofitClient getInstance(Context context){
        if (context!=null){
            mContext = context;
        }
        return SingletonHolder.INSTANCE;

    }

    public static RetrofitClient getInstance(Context context,String url){
        //url 适用于不同的baseurl
        if (context!=null){
            mContext = context;
        }

        sNewInstance = new RetrofitClient(context, url);
        return sNewInstance;

    }



}
