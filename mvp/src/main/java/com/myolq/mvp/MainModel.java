package com.myolq.mvp;

import com.myolq.frame.callback.GsonCallBack;
import com.myolq.frame.callback.StringCallBack;
import com.myolq.frame.loader.OkgoLoader;
import com.myolq.mvp.bean.User;

/**
 * Created by Administrator on 2017/6/19.
 */

public class MainModel implements MainContract.MainModel{


    @Override
    public void getUser(String user, StringCallBack callBack) {
        String url="https://api.bmob.cn/1/users?objectId="+user;
        OkgoLoader.getInstance().sendByGet(url,callBack);

//        UserBean userBean=new UserBean();
//        userBean.setUsername("ou123456");
//        userBean.setPassword("123456");
//        OkgoManage.getInstance().sendByPostUploadingJson(url,userBean,callBack);

    }

    @Override
    public void getUser(GsonCallBack<User> callBack) {
        String url="https://api.bmob.cn/1/users";
        OkgoLoader.getInstance().sendByGet(url,callBack);
    }
}
