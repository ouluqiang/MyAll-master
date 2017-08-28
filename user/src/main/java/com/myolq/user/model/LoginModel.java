package com.myolq.user.model;

import com.myolq.frame.config.NetConfig;
import com.myolq.frame.callback.StringCallBack;
import com.myolq.frame.loader.OkgoLoader;
import com.myolq.user.contract.LoginContract;

/**
 * Created by root on 2017-08-24.
 */

public class LoginModel implements LoginContract.Model{
    @Override
    public void getLogin(String username, String password, StringCallBack callBack) {
        String url= NetConfig.USERS+"?username="+username+"&&password="+password;
        OkgoLoader.getInstance().sendByGet(url,callBack);
    }
//    @Override
//    public void getUser(String user, StringCallBack callBack) {
//        String url="https://api.bmob.cn/1/users?objectId="+user;
//        OkgoLoader.getInstance().sendByGet(url,callBack);
//
////        UserBean userBean=new UserBean();
////        userBean.setUsername("ou123456");
////        userBean.setPassword("123456");
////        OkgoManage.getInstance().sendByPostUploadingJson(url,userBean,callBack);
//
//    }
//
//    @Override
//    public void getUser(GsonCallBack<UserBean> callBack) {
//        String url="https://api.bmob.cn/1/users";
//        OkgoLoader.getInstance().sendByGet(url,callBack);
//    }
}
