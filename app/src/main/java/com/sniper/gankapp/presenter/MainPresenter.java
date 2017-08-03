package com.sniper.gankapp.presenter;

import android.content.Context;
import android.util.Log;

import com.sniper.gankapp.ListData;
import com.sniper.gankapp.iview.IMainView;
import com.sniper.gankapp.net.RetrofitClient;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zhaohongru on 2017-08-03.
 * PackageName: com.sniper.gankapp.presenter.MainPresenter
 * Description：
 */
public class MainPresenter extends BasePresenter<IMainView>{

    private  final String TAG = context.getClass().getSimpleName();

    public MainPresenter(Context context, IMainView iView) {
        super(context, iView);
    }

    public void getData() {

        RetrofitClient.getInstance(context).getService().list(100,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<ListData>>() {
                    @Override
                    public void accept(List<ListData> listDatas) throws Exception {
                        Log.e(TAG, "accept: 成功" );
                        }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "accept: 失败" );
                    }
                });



    }
}