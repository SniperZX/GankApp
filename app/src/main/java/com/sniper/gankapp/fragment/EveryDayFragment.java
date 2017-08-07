package com.sniper.gankapp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.sniper.gankapp.EveryDayAdapter;
import com.sniper.gankapp.R;
import com.sniper.gankapp.WebActivity;
import com.sniper.gankapp.data.Result;
import com.sniper.gankapp.iview.IEveryDayView;
import com.sniper.gankapp.presenter.EverydayPresenter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EveryDayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EveryDayFragment extends BaseFragment<EverydayPresenter> implements IEveryDayView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    protected CardView search;
    protected RecyclerView recyclerView;
    protected TwinklingRefreshLayout refreshLayout;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    List<Result> datas;
    EveryDayAdapter mainBaseAdapter;
    private int page = 1;

    public EveryDayFragment() {
        // Required empty public constructor
    }


    public static EveryDayFragment newInstance(String param1, String param2) {
        EveryDayFragment fragment = new EveryDayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_everyday;
    }

    @Override
    public void initPresenter() {
        if(datas==null) {
            datas = new ArrayList<>();
        }
        presenter = new EverydayPresenter(getContext(), this);
        presenter.init();
    }

    @Override
    public void initView() {
        search = (CardView) rootView.findViewById(R.id.search);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        refreshLayout = (TwinklingRefreshLayout) rootView.findViewById(R.id.refreshLayout);
        mainBaseAdapter = new EveryDayAdapter(getContext(), datas);
        recyclerView.setAdapter(mainBaseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        getData(page);
        refreshLayout.setFloatRefresh(true);
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                datas.clear();
                page=1;
                getData(page);
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                page++;
                getData(page);
            }
        });

        mainBaseAdapter.setOnItemClick(new EveryDayAdapter.OnItemClick() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), WebActivity.class);
                intent.putExtra("title", datas.get(position).getDesc());
                intent.putExtra("url",datas.get(position).getUrl());
                getContext().startActivity(intent);
            }
        });


    }

    public void getData(int page) {
        presenter.getData(page);
    }

    @Override
    public void getDataSucc(List<Result> list) {
        datas.clear();
        datas.addAll(list);
        refreshLayout.finishLoadmore();
        refreshLayout.finishRefreshing();
        mainBaseAdapter.notifyDataSetChanged();
    }

//    @Override
//    public void getDataSucc(ListData listDatas) {
//        datas.getResults().addAll(listDatas.getResults());
//        refreshLayout.finishLoadmore();
//        refreshLayout.finishRefreshing();
//        mainBaseAdapter.notifyDataSetChanged();
//
//    }
}
