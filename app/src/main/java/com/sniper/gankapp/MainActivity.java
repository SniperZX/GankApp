package com.sniper.gankapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.sniper.gankapp.activity.BaseActivity;
import com.sniper.gankapp.fragment.EveryDayFragment;
import com.sniper.gankapp.iview.IMainView;
import com.sniper.gankapp.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainView {

    protected BottomNavigationView bottomNav;
    protected TwinklingRefreshLayout refreshLayout;
    protected ViewPager viewpager;
    MainPresenter mainPresenter;
    protected RecyclerView recyclerView;
    int page = 1;


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
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(EveryDayFragment.newInstance("index","1"));
        viewPagerAdapter.addFragment(CategoryFragment.newInstance("category","2"));
        viewPagerAdapter.addFragment(MeFragment.newInstance("me","3"));
        viewpager.setAdapter(viewPagerAdapter);
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
                switch (item.getItemId()) {
                    case R.id.everyday:
                        viewpager.setCurrentItem(0);
                        break;
                    case R.id.category:
                        viewpager.setCurrentItem(1);
                        break;
                    case R.id.me:
                        viewpager.setCurrentItem(2);
                        break;

                }
                return true;
            }
        });
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0) {
                    bottomNav.setSelectedItemId(R.id.everyday);
                }else if(position==1){
                    bottomNav.setSelectedItemId(R.id.category);
                }else {
                    bottomNav.setSelectedItemId(R.id.me);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


       /* recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mainBaseAdapter = new MainRecyclerAdapter(this, datas);
        recyclerView.setAdapter(mainBaseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        getData(page);
        refreshLayout = (TwinklingRefreshLayout) findViewById(R.id.refreshLayout);
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
                getData(page);
            }
        });*/


    }





}
