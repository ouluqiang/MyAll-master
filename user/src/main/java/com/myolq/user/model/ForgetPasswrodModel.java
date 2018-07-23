package com.myolq.user.model;

import com.myolq.frame.bean.ErrorBean;
import com.myolq.frame.loader.callback.GsonCallBack;
import com.myolq.frame.loader.callback.StringCallBack;
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

    @Override
    public void getRequestPasswordReset(String email, GsonCallBack<ErrorBean> callBack) {
        String url= NetConfig.REQUEST_PASSWORD_RESET;
        Map<String,String> map=new HashMap<>();
        map.put("email",email);
        OkgoLoader.getInstance().sendByPostUploadingJson(url,map,callBack);
    }

//    @Override
//    public void getIssue( String session, StringCallBack callBack) {
//        String url=NetConfig.USERS;
//    }

//    @Override
//    public void getSelectUser(String username, String safetyIssue, String safetyAnswer, StringCallBack callBack) {
//        String param="?safetyIssue="+safetyIssue+"&&safetyAnswer="+safetyAnswer+"&&";
//        if (RegexUtils.checkEmail(username)){
//            param+="email="+username;
//        }else{
//            param+="username="+username;
//        }
//        String url=NetConfig.USERS+param;
//        OkgoLoader.getInstance().sendByGet(url,callBack);
//    }
}
