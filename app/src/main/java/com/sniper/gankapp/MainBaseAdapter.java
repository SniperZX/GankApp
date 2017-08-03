package com.sniper.gankapp;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */

public class MainBaseAdapter extends BaseQuickAdapter<ListData.ResultsBean,BaseViewHolder> {
    public MainBaseAdapter(@Nullable List<ListData.ResultsBean> data) {
        super(R.layout.main_item,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ListData.ResultsBean item) {
        helper.setText(R.id.subtitle,item.getDesc())
                .setText(R.id.author,item.getWho());
        helper.setImageDrawable(R.id.img,null);
        if(item.getImages()!=null) {
            Glide.with(mContext).load(item.getImages().get(0)+"?imageView2/0/w/100").placeholder(null).crossFade().into((ImageView) helper.getView(R.id.img));
        }
    }
}
