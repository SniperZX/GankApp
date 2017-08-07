package com.sniper.gankapp.presenter;

import android.content.Context;

import com.sniper.gankapp.data.Response;
import com.sniper.gankapp.data.Result;
import com.sniper.gankapp.iview.IItemView;
import com.sniper.gankapp.net.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zhaohongru on 2017-08-07.
 * PackageName: com.sniper.gankapp.presenter.ItemPresenter
 * Description：
 */
public class ItemPresenter extends BasePresenter<IItemView> {

    List<Result> list;

    public ItemPresenter(Context context, IItemView iView) {
        super(context, iView);
        list = new ArrayList<>();
    }

    public void getData(int index, int page) {

        Observable<Response> responseObservable = null;
        switch (index) {
            case 0:
                responseObservable = RetrofitClient.getInstance(context).getService()
                        .listAndroid(15, page);
                break;
            case 1:
                responseObservable = RetrofitClient.getInstance(context).getService()
                        .listiOS(15, page);
                break;
            case 2:
                responseObservable = RetrofitClient.getInstance(context).getService()
                        .listQianDuan(15, page);
                break;
            case 3:
                responseObservable = RetrofitClient.getInstance(context).getService()
                        .listTuoZhan(15, page);
                break;
            case 4:
                responseObservable = RetrofitClient.getInstance(context).getService()
                        .listShiPing(15, page);
                break;


        }
        responseObservable.concatMap(new Function<Response, ObservableSource<Result>>() {
            @Override
            public ObservableSource<Result> apply(@NonNull Response response) throws Exception {

                return Observable.fromIterable(response.getResults());
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        list.add(result);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        iView.getDataSucc(list);
                    }
                });

    }
}
