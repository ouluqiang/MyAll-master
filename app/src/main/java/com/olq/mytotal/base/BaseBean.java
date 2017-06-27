package com.olq.mytotal.base;

/**
 * Created by Administrator on 2017/2/9.
 */

public class BaseBean {
    private String mobile;
    private String password;

    public BaseBean(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    public String getMobile() {

        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
