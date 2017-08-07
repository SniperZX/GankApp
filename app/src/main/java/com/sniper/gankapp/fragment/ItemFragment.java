package com.sniper.gankapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sniper.gankapp.ItemAdapter;
import com.sniper.gankapp.R;
import com.sniper.gankapp.data.Result;
import com.sniper.gankapp.iview.IItemView;
import com.sniper.gankapp.presenter.ItemPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemFragment extends BaseFragment<ItemPresenter> implements IItemView {


    protected RecyclerView recyclerView;

    ItemAdapter itemAdapter;
    List<Result> list;
    int page = 0;
    int index;
    public ItemFragment() {
        // Required empty public constructor
    }

    public static ItemFragment newInstance(int param1) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putInt("index", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_item;
    }

    @Override
    public void initPresenter() {
        if(list==null) {
            list = new ArrayList<>();
        }
        index = getArguments().getInt("index");
        presenter = new ItemPresenter(getContext(), this);
        presenter.init();
    }

    @Override
    public void initView() {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        itemAdapter = new ItemAdapter(getContext(),list);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(itemAdapter);
        getData(page);
    }

    private void getData(int page) {
        presenter.getData(index,page);
    }

    @Override
    public void getDataSucc(List<Result> list) {
        this.list.clear();
        this.list.addAll(list);

        itemAdapter.notifyDataSetChanged();
    }
}
