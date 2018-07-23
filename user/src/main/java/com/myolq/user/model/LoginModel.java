package com.myolq.user.model;

import com.myolq.frame.bean.UserBean;
import com.myolq.frame.loader.callback.GsonCallBack;
import com.myolq.frame.config.NetConfig;
import com.myolq.frame.loader.callback.StringCallBack;
import com.myolq.frame.loader.OkgoLoader;
import com.myolq.frame.utils.RegexUtils;
import com.myolq.user.contract.LoginContract;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 2017-08-24.
 */

public class LoginModel implements LoginContract.Model{

    @Override
    public void getLogin(String username, String password, StringCallBack callBack) {
//        String param="?password="+password+"&&";
//        if (RegexUtils.checkEmail(username)){
//            param+="email="+username;
//        }else{
//            param+="username="+username;
//
//        }
//        String url= NetConfig.LOGIN+param;
//        OkgoLoader.getInstance().sendByGet(url,callBack);

        String url= NetConfig.LOGIN;
        Map<String,String> map=new HashMap<>();
        map.put("password",password);
        if (RegexUtils.checkEmail(username)){
            map.put("email",username);
        }else{
            map.put("username",username);
        }
        OkgoLoader.getInstance().sendByPostUploadingJson(url,map,callBack);
    }

    @Override
    public void getLogin(UserBean userBean, GsonCallBack<UserBean> callBack) {
        String url= NetConfig.LOGIN;
        OkgoLoader.getInstance().sendByPostUploadingJson(url,userBean,callBack);
    }
}
