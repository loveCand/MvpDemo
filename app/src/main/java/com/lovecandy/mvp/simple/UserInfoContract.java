package com.lovecandy.mvp.simple;

import com.lovecandy.mvp.base.IModel;
import com.lovecandy.mvp.base.IView;
import com.lovecandy.mvp.bean.UserInfo;

/**
 * @author Created by lichao
 * @desc 协同类,先定义好方法.不同人实现不同的方法
 * @time 2018/5/7 09:37
 * 邮箱：lichao@voole.com
 */

public interface UserInfoContract {
    // user View 层
    interface UserInfoView extends IView {
        void onLoading();
        void onError();
        void onSucceed(UserInfo userInfo);
    }

    // user presenter 层
    interface UserInfoPresenter {
        void getUsers(String token);
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,如是否使用缓存
    interface UserInfoModel extends IModel {
        UserInfo getUsers(String token);
    }

}
