package com.lovecandy.mvp.simple;

import com.lovecandy.mvp.bean.UserInfo;

/**
 * @author Created by lichao
 * @desc  获取数据方法,是个耗时操作
 * @time 2018/5/7 09:39
 * 邮箱：lichao@voole.com
 */

public class UserInfoModel implements UserInfoContract.UserInfoModel {
    @Override
    public UserInfo getUsers(String token) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new UserInfo("loveCandy",token);
    }
}
