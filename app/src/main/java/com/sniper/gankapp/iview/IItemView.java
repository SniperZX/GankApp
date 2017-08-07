package com.sniper.gankapp.iview;

import com.sniper.gankapp.data.Result;

import java.util.List;

/**
 * Created by zhaohongru on 2017-08-07.
 * PackageName: com.sniper.gankapp.iview.IItemView
 * Description：
 */
public interface IItemView extends IBaseView{
    void getDataSucc(List<Result> list);
}
