package com.myolq.frame.callback;


import com.lzy.okgo.model.Response;

import java.lang.reflect.Type;


/**
 * Created by Administrator on 2016/10/20 0020.
 */

public abstract class GsonCallBack<T> extends HttpCallBack<T>{

    private Type type;

    public Type getType() {
        return type;
    }

    public GsonCallBack(Type type) {
        // TODO Auto-generated constructor stub
        this.type=type;
    }

    public abstract void onSuccess(T t);

    public abstract void onError(Response response, Exception e);


}
