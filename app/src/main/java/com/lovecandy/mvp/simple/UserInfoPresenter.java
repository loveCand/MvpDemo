package com.lovecandy.mvp.simple;

import com.lovecandy.mvp.base.BasePresenter;
import com.lovecandy.mvp.bean.UserInfo;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Created by lichao
 * @desc
 * @time 2018/5/7 09:41
 * 邮箱：lichao@voole.com
 */

public class UserInfoPresenter extends BasePresenter<UserInfoContract.UserInfoView,UserInfoModel> implements UserInfoContract.UserInfoPresenter {


    @Override
    public void getUsers(String token) {
        // 应该是 RXJava + OkHttp + Retrofit + Dagger 结合
        getView().onLoading();
        // 这里只用 RXJava 模拟一下
        Observable.just("").map(new Function<String, UserInfo>() {
            @Override
            public UserInfo apply(String token) throws Exception {
                return model.getUsers(token);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserInfo>() {
                    @Override
                    public void accept(UserInfo userInfo) throws Exception {
                        //每次都需要去判断view !=null 这个也很麻烦
                        // 都是接口,通用代码view!=null 统一处理,这个是AOP思想()
                        getView().onSucceed(userInfo);
                    }
                });
    }
}
