package com.myolq.frame.config;

import static android.R.attr.id;

/**
 * Created by Administrator on 2017/1/23.
 */

public interface NetConfig {

//    public String APPID_KEY="X-Bmob-Application-Id";
//    public String APPID_VALUE="034ddf7a49a4fdd1146c23d162994260";
    public String APPID_KEY="X-LC-Id";
    public String APPID_VALUE="I8FvRR1C4Jk1wFYF1AqXkqCq-9Nh9j0Va";

//    public String APIKEY_KEY="X-Bmob-REST-API-Key";
//    public String APIKEY_VALUE="3d82db4d622b044cb19b4f287a72431b";
    public String APIKEY_KEY="X-LC-Key";
    public String APIKEY_VALUE="ihPu7rgeCIsnAlwyGUNwGhfp";

    public String TYPE_KEY="Content-Type";
    public String TYPE_VALUE="application/json";

//    public String URL="https://api.bmob.cn/1/" ;
    public String URL="https://api.leancloud.cn/1.1/" ;
    //用户
    public String USERS=URL+"users";
    //登录
    public String LOGIN=URL+"login";
    //邮箱验证注册
    public String REQUEST_EMAIL_VERIFY=URL+"requestEmailVerify";
    //邮箱重置密码
    public String REQUEST_PASSWORD_RESET=URL+"requestPasswordReset";

}
