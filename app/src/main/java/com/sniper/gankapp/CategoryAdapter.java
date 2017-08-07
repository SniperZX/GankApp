package com.sniper.gankapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zhaohongru on 2017-08-07.
 * PackageName: com.sniper.gankapp.CategoryAdapter
 * Description：
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    String[] categorys = {"Android","iOS","前端","拓展资源","休息视频","福利"};

    Context context;
    public CategoryAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(
                context).inflate(R.layout.category_item, parent,
                false);
        return new CategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.ViewHolder holder, int position) {
            holder.tv.setText(categorys[position]);
    }

    @Override
    public int getItemCount() {
        return categorys.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.categoryName);
        }
    }

}
