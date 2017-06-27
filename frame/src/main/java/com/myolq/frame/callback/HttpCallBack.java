package com.myolq.frame.callback;

import com.lzy.okgo.model.Response;

import okhttp3.Call;

/**
 * Created by Administrator on 2017/1/23.
 */

public abstract class HttpCallBack<T> extends BaseCallBack{

    public abstract void onSuccess(T t);

    public abstract void onError(Response response, Exception e);

}
