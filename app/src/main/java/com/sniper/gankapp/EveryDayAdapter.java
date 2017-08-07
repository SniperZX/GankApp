package com.sniper.gankapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sniper.gankapp.data.Result;

import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */

public class EveryDayAdapter extends RecyclerView.Adapter<EveryDayAdapter.Holder> {
    private List<Result> results;
    private Context context;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    OnItemClick onItemClick;

    public EveryDayAdapter(Context context, List<Result> results) {
        this.results = results;
        this.context = context;
    }

    @Override
    public EveryDayAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                context).inflate(R.layout.everyday_item, parent,
                false);
        return new EveryDayAdapter.Holder(view);

    }

    @Override
    public void onBindViewHolder(final EveryDayAdapter.Holder holder, int position) {
        EveryDayAdapter.Holder tmpHolder = holder;
        Result tmp = results.get(position);
        if(onItemClick!=null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int positon = holder.getLayoutPosition();
                    onItemClick.onItemClick(holder.itemView,positon);
                }
            });
        }
        tmpHolder.author.setVisibility(View.VISIBLE);
        tmpHolder.title.setVisibility(View.VISIBLE);
        tmpHolder.title.setText(tmp.getDesc());
        tmpHolder.author.setText(tmp.getWho());
        tmpHolder.img.setImageDrawable(null);
        if (position == 0) {
            tmpHolder.everydate.setVisibility(View.VISIBLE);
            tmpHolder.everydate.setText(tmp.getPublishedAt().split("T")[0]);
        } else {
            if (!TextUtils.equals(tmp.getPublishedAt(), results.get(position - 1).getPublishedAt())) {
                tmpHolder.everydate.setVisibility(View.VISIBLE);
                tmpHolder.everydate.setText(tmp.getPublishedAt().split("T")[0]);
            } else {
                tmpHolder.everydate.setVisibility(View.GONE);
            }

        }

        if (tmp.getImages() != null && tmp.getImages().size() != 0) {
            tmpHolder.img.setVisibility(View.VISIBLE);
            Glide.with(context).load(tmp.getImages().get(0) + "?imageView2/0/w/400").diskCacheStrategy(DiskCacheStrategy.SOURCE).dontAnimate().placeholder(null).into(tmpHolder.img);
        } else {
            tmpHolder.img.setVisibility(View.GONE);
        }
        if (tmp.getType().equals("福利")) {
            tmpHolder.author.setVisibility(View.GONE);
            tmpHolder.title.setVisibility(View.GONE);
            tmpHolder.img.setVisibility(View.VISIBLE);
            Glide.with(context).load(tmp.getUrl()).diskCacheStrategy(DiskCacheStrategy.SOURCE).dontAnimate().placeholder(null).into(tmpHolder.img);
        }
    }


    @Override
    public int getItemCount() {
        return results.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        TextView title, author, everydate;
        ImageView img;

        public Holder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.subtitle);
            author = (TextView) itemView.findViewById(R.id.author);
            img = (ImageView) itemView.findViewById(R.id.img);
            everydate = (TextView) itemView.findViewById(R.id.everydate);
        }

    }

    public interface  OnItemClick{
        void onItemClick(View view,int position);
    }



}
