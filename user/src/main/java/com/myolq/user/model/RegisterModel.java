package com.myolq.user.model;

import com.myolq.frame.config.NetConfig;
import com.myolq.frame.callback.StringCallBack;
import com.myolq.frame.loader.OkgoLoader;
import com.myolq.user.bean.UserBean;
import com.myolq.user.contract.RegisterContract;

/**
 * Created by root on 2017-08-24.
 */

public class RegisterModel implements RegisterContract.Model {

    @Override
    public void getRegister(UserBean user, StringCallBack callBack) {
        String url= NetConfig.USERS;
        OkgoLoader.getInstance().sendByPostUploadingJson(url,user,callBack);
    }
}
