package com.sniper.gankapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2017/8/3.
 */

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.Holder> {



    private ListData listData;
    private Context context;


    public MainRecyclerAdapter(Context context,ListData listData) {
        this.listData = listData;
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
        ListData.ResultsBean tmp = listData.getResults().get(position);
        holder.title.setText(tmp.getDesc());
        holder.author.setText(tmp.getWho());
        holder.img.setImageDrawable(null);
        if(tmp.getImages()!=null&&tmp.getImages().size()!=0) {
                Glide.with(context).load(tmp.getImages().get(0) + "?imageView2/0/w/100").dontAnimate().placeholder(null).into(holder.img);
        }
    }

    @Override
    public int getItemCount() {
        return listData.getResults().size();
    }

    class Holder extends RecyclerView.ViewHolder{

            TextView title,author;
            ImageView img;
            public Holder(View itemView) {
                super(itemView);
                title = (TextView) itemView.findViewById(R.id.title);
                author = (TextView) itemView.findViewById(R.id.author);
                img = (ImageView) itemView.findViewById(R.id.img);
            }




        }

}
