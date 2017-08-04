package com.sniper.gankapp.presenter;

import android.content.Context;

import com.sniper.gankapp.iview.IMainView;

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


}
