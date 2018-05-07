package com.lovecandy.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Created by lichao
 * @desc activity 基类,
 * @time 2018/5/7 10:01
 * 邮箱：lichao@voole.com
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IView {

    private P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        //创建只能交给子类,每个activity都不一样
        presenter = creatPresenter();
        presenter.attachView(this);
        initView();
        initData();
    }

    protected abstract P creatPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void setContentView();

    public P getPresenter() {
        return presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettachView();
    }
}
