package com.sniper.gankapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.sniper.gankapp.fragment.BaseFragment;
import com.sniper.gankapp.iview.IIndexView;
import com.sniper.gankapp.presenter.IndexPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IndexFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IndexFragment extends BaseFragment<IndexPresenter> implements IIndexView {
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
    ListData datas;
    MainRecyclerAdapter mainBaseAdapter;
    private int page = 1;

    public IndexFragment() {
        // Required empty public constructor
    }


    public static IndexFragment newInstance(String param1, String param2) {
        IndexFragment fragment = new IndexFragment();
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
        return R.layout.fragment_index;
    }

    @Override
    public void initPresenter() {
        datas = new ListData();
        datas.setResults(new ArrayList<ListData.ResultsBean>());
        presenter = new IndexPresenter(getContext(), this);
        presenter.init();
    }

    @Override
    public void initView() {
        search = (CardView) rootView.findViewById(R.id.search);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        refreshLayout = (TwinklingRefreshLayout) rootView.findViewById(R.id.refreshLayout);
  //      mainBaseAdapter = new MainRecyclerAdapter(getContext(), datas);
        recyclerView.setAdapter(mainBaseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        getData(page);
        refreshLayout.setFloatRefresh(true);
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                datas.getResults().clear();
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

    }

    public void getData(int page) {
        presenter.getData(page);
    }

    @Override
    public void getDataSucc(ListData listDatas) {
        datas.getResults().addAll(listDatas.getResults());
        refreshLayout.finishLoadmore();
        refreshLayout.finishRefreshing();
        mainBaseAdapter.notifyDataSetChanged();

    }
}
