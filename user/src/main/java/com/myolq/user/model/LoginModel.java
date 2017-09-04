package com.myolq.user.model;

import com.myolq.frame.config.NetConfig;
import com.myolq.frame.callback.StringCallBack;
import com.myolq.frame.loader.OkgoLoader;
import com.myolq.frame.utils.RegexUtils;
import com.myolq.user.contract.LoginContract;

/**
 * Created by root on 2017-08-24.
 */

public class LoginModel implements LoginContract.Model{

    @Override
    public void getLogin(String username, String password, StringCallBack callBack) {
        String param="?password="+password+"&&";
        if (RegexUtils.checkEmail(username)){
            param+="email="+username;
        }else{
            param+="username="+username;

        }
        String url= NetConfig.LOGIN+param;
        OkgoLoader.getInstance().sendByGet(url,callBack);
    }
}
