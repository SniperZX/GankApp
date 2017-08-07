package com.sniper.gankapp.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sniper.gankapp.iview.IBaseView;
import com.sniper.gankapp.presenter.BasePresenter;


public abstract class ToolBarActivity<T extends BasePresenter> extends BaseActivity implements IBaseView {
    protected ActionBar actionBar;
    protected T presenter;
    protected boolean isToolBarHiding = false;

    protected Toolbar toolbar;
    protected AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar();
    }



    protected boolean canBack(){
        return true;
    }

    protected boolean isHasBack(){
        return true;

    }

    protected void initToolBar(){
        if(isHasBack()) {
            setSupportActionBar(toolbar);
            actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(canBack());
           //     actionBar.setTitle(" ");
            }
            toolbarClick();
        }
        onViewInitComplete();
    }

    public void toolbarClick() {
        toolbar.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void onViewInitComplete(){

    }


}
