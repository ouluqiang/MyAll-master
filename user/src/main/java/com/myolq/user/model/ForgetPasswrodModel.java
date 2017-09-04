package com.myolq.user.model;

import com.myolq.frame.callback.StringCallBack;
import com.myolq.frame.config.NetConfig;
import com.myolq.frame.loader.OkgoLoader;
import com.myolq.user.contract.ForgetPasswrodContract;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 2017-09-01.
 */

public class ForgetPasswrodModel implements ForgetPasswrodContract.Model{


    @Override
    public void getRequestPasswordReset(String email, StringCallBack callBack) {
        String url= NetConfig.REQUEST_PASSWORD_RESET;
        Map<String,String> map=new HashMap<>();
        map.put("email",email);
        OkgoLoader.getInstance().sendByPostUploadingJson(url,map,callBack);
    }
}
