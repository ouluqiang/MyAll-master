package com.myolq.user.model;

import android.util.ArrayMap;

import com.myolq.frame.config.NetConfig;
import com.myolq.frame.callback.StringCallBack;
import com.myolq.frame.loader.OkgoLoader;
import com.myolq.user.bean.UserBean;
import com.myolq.user.contract.RegisterContract;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 2017-08-24.
 */

public class RegisterModel implements RegisterContract.Model {

    @Override
    public void getRegister(UserBean user, StringCallBack callBack) {
        String url= NetConfig.USERS;
        OkgoLoader.getInstance().sendByPostUploadingJson(url,user,callBack);
    }

    @Override
    public void getRequestEmailVerify(String email, StringCallBack callBack) {
        String url= NetConfig.REQUEST_EMAIL_VERIFY;
        Map<String,String> map=new HashMap<>();
        map.put("email",email);
        OkgoLoader.getInstance().sendByPostUploadingJson(url,map,callBack);
    }

}
