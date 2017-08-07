package com.sniper.gankapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sniper.gankapp.CategoryAdapter;
import com.sniper.gankapp.R;
import com.sniper.gankapp.iview.ICategroyView;
import com.sniper.gankapp.presenter.CategoryPresenter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends BaseFragment<CategoryPresenter> implements ICategroyView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    protected RecyclerView recyclerView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public CategoryFragment() {
        // Required empty public constructor
    }

    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_category;
    }

    @Override
    public void initPresenter() {
        presenter = new CategoryPresenter(getContext(), this);
        presenter.init();
    }

    @Override
    public void initView() {
/*        viewpager = (ViewPager) rootView.findViewById(R.id.viewpager);
        tabs = (TabLayout) rootView.findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("Android"),0);
        tabs.addTab(tabs.newTab().setText("iOS"),1);
        tabs.addTab(tabs.newTab().setText("前端"),2);
        tabs.addTab(tabs.newTab().setText("拓展资源"),3);
        tabs.addTab(tabs.newTab().setText("休息视频"),4);
        viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPagerAdapter.addFragment(ItemFragment.newInstance(0));
//        viewPagerAdapter.addFragment(ItemFragment.newInstance(1));
//        viewPagerAdapter.addFragment(ItemFragment.newInstance(2));
//        viewPagerAdapter.addFragment(ItemFragment.newInstance(3));
//        viewPagerAdapter.addFragment(ItemFragment.newInstance(4));
        viewpager.setAdapter(viewPagerAdapter);
        tabs.setupWithViewPager(viewpager);*/
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 1;
            }
        });
        recyclerView.setAdapter(new CategoryAdapter(getContext()));
    }
}
