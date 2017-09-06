package com.myolq.home.model;

import com.lzy.okgo.model.HttpHeaders;
import com.myolq.frame.bean.UserBean;
import com.myolq.frame.callback.GsonCallBack;
import com.myolq.frame.callback.StringCallBack;
import com.myolq.frame.config.NetConfig;
import com.myolq.frame.config.UserConfig;
import com.myolq.frame.loader.OkgoLoader;
import com.myolq.frame.utils.LogUtils;
import com.myolq.home.contract.LaunchContract;

/**
 * Created by root on 2017-09-04.
 */

public class LaunchModel implements LaunchContract.Model{
//    @Override
//    public void getMe(String session, StringCallBack callBack) {
//        String url= NetConfig.ME;
//        HttpHeaders headers=new HttpHeaders();
//        headers.put(NetConfig.APPID_KEY, NetConfig.APPID_VALUE);
//        headers.put(NetConfig.APIKEY_KEY, NetConfig.APIKEY_VALUE);
//        headers.put("X-LC-Session", session);
//        LogUtils.i("session:"+session);
//        OkgoLoader.getInstance().sendByGet(url,headers,callBack);
//    }

    @Override
    public void getMe(String session, GsonCallBack<UserBean> callBack) {
        String url= NetConfig.ME;
        HttpHeaders headers=new HttpHeaders();
        headers.put(NetConfig.APPID_KEY, NetConfig.APPID_VALUE);
        headers.put(NetConfig.APIKEY_KEY, NetConfig.APIKEY_VALUE);
        headers.put("X-LC-Session", session);
        LogUtils.i("session:"+session);
        OkgoLoader.getInstance().sendByGet(url,headers,callBack);
    }
}
