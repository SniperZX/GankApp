package com.sniper.gankapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sniper.gankapp.activity.BaseActivity;
import com.sniper.gankapp.iview.IMainView;
import com.sniper.gankapp.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainView {

    protected BottomNavigationView bottomNav;
    MainPresenter mainPresenter;
    protected RecyclerView recyclerView;
    int page = 1;
    MainBaseAdapter mainBaseAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {
        mainPresenter = new MainPresenter(this, this);
        mainPresenter.init();
    }


    @Override
    public void initView() {

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        bottomNav = (BottomNavigationView) findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.everyday:
                        bottomNav.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        break;
                    case R.id.category:
                        break;
                    case R.id.me:
                        break;

                }
                return true;
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        getData(page);

    }

    public void getData(int page){
        mainPresenter.getData(page);
    }


    @Override
    public void getDataSucc(ListData listDatas) {
        page++;
        if(mainBaseAdapter==null) {
            mainBaseAdapter = new MainBaseAdapter(listDatas.getResults());
            recyclerView.setAdapter(mainBaseAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            mainBaseAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                @Override
                public void onLoadMoreRequested() {
                    getData(page);
                }
            }, recyclerView);
        }else{
            mainBaseAdapter.addData(listDatas.getResults());
            mainBaseAdapter.loadMoreComplete();

        }
    }
}
