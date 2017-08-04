package com.sniper.gankapp.presenter;

import android.content.Context;
import android.util.Log;

import com.sniper.gankapp.ListData;
import com.sniper.gankapp.iview.IIndexView;
import com.sniper.gankapp.net.RetrofitClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by zhaohongru on 2017-08-04.
 * PackageName: com.sniper.gankapp.presenter.IndexPresenter
 * Description：
 */
public class IndexPresenter extends BasePresenter<IIndexView> {
    public IndexPresenter(Context context, IIndexView iView) {
        super(context, iView);
    }


    public void getData(int page) {

        RetrofitClient.getInstance(context).getService().list(15, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Consumer<ListData>() {
                    @Override
                    public void accept(ListData listDatas) throws Exception {
                        Log.e(TAG, "accept: 成功");
                        iView.getDataSucc(listDatas);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "accept: 失败" + throwable.getMessage());
                    }
                });


    }

}
