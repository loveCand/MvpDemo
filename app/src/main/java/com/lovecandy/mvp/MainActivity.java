package com.lovecandy.mvp;

import android.widget.TextView;

import com.lovecandy.mvp.base.BaseActivity;
import com.lovecandy.mvp.bean.UserInfo;
import com.lovecandy.mvp.simple.UserInfoContract;
import com.lovecandy.mvp.simple.UserInfoPresenter;

public class MainActivity extends BaseActivity<UserInfoPresenter> implements UserInfoContract.UserInfoView {

    private TextView textView;
    @Override
    public void onLoading() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onSucceed(UserInfo userInfo) {
        textView.setText(userInfo.getName());
    }

    @Override
    protected UserInfoPresenter creatPresenter() {
        return new UserInfoPresenter();
    }

    @Override
    protected void initData() {
        getPresenter().getUsers("");
    }

    @Override
    protected void initView() {
        textView = findViewById(R.id.textView);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }
}
