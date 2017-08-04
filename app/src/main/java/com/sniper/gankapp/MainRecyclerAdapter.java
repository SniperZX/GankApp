package com.sniper.gankapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sniper.gankapp.data.Result;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.Holder> {



    private  List<Result> results;
    private Context context;


    public MainRecyclerAdapter(Context context, List<Result> results) {
        this.results = results;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(
                context).inflate(R.layout.main_item, parent,
                false);
        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Holder tmpHolder = holder;
        Result tmp = results.get(position);
        tmpHolder.title.setText(tmp.getDesc());
        tmpHolder.author.setText(tmp.getWho());
        tmpHolder.img.setImageDrawable(null);
        if(tmp.getImages()!=null&&tmp.getImages().size()!=0) {
            tmpHolder.img.setVisibility(View.VISIBLE);
                Glide.with(context).load(tmp.getImages().get(0) + "?imageView2/0/w/100").dontAnimate().placeholder(null).into(tmpHolder.img);
        }else{
            tmpHolder.img.setVisibility(View.GONE);

        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class Holder extends RecyclerView.ViewHolder{

            TextView title,author;
            ImageView img;
            public Holder(View itemView) {
                super(itemView);
                title = (TextView) itemView.findViewById(R.id.subtitle);
                author = (TextView) itemView.findViewById(R.id.author);
                img = (ImageView) itemView.findViewById(R.id.img);
            }




        }

}
