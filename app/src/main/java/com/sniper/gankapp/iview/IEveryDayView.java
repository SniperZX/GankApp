package com.sniper.gankapp.iview;

import com.sniper.gankapp.data.Result;

import java.util.List;

/**
 * Created by zhaohongru on 2017-08-04.
 * PackageName: com.sniper.gankapp.iview.IEveryDayView
 * Description：
 */
public interface IEveryDayView extends IBaseView{
    void getDataSucc(List<Result> list);
}
