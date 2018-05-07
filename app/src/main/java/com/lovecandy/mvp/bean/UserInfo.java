package com.lovecandy.mvp.bean;

/**
 * @author Created by lichao
 * @desc bean 对象包装用户信息
 * @time 2018/5/7 09:38
 * 邮箱：lichao@voole.com
 */

public class UserInfo {
    public UserInfo(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    private  String name;
    private  String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
