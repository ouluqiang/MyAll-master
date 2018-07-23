package com.myolq.frame.loader.callback;

import com.lzy.okgo.model.Response;

/**
 * Created by Administrator on 2017/1/23.
 */

public abstract class HttpCallBack<T> extends BaseCallBack{

    public abstract void onSuccess(T t);

    public abstract void onError(Response response);

}
