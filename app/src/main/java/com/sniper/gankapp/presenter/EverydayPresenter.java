package com.sniper.gankapp.presenter;

import android.content.Context;

import com.sniper.gankapp.data.Response;
import com.sniper.gankapp.data.Result;
import com.sniper.gankapp.iview.IEveryDayView;
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
 * Created by zhaohongru on 2017-08-04.
 * PackageName: com.sniper.gankapp.presenter.EverydayPresenter
 * Description：
 */
public class EverydayPresenter extends BasePresenter<IEveryDayView>{

    List<Result> list;

    public EverydayPresenter(Context context, IEveryDayView iView) {
        super(context, iView);
        list = new ArrayList<>();
    }

    public void getData(int page) {

        RetrofitClient.getInstance(context).getService()
                .listAll(15,page)
                .concatMap(new Function<Response, ObservableSource<Result>>() {
                    @Override
                    public ObservableSource<Result> apply(@NonNull Response response) throws Exception {
                        if(!response.isError()) {
                            return Observable.fromIterable(response.getResults());
                        }else{

                            return  null;
                        }
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
                       // getMvpview().showError();
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        iView.getDataSucc(list);
                    }
                });


    }
}
