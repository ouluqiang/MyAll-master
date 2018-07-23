package com.myolq.frame.loader.callback;


import com.myolq.frame.bean.BaseBean;
import com.myolq.frame.utils.GsonUtils;
import com.myolq.frame.utils.LogUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * Created by Administrator on 2016/10/20 0020.
 */

public abstract class GsonCallBack<T> extends StringCallBack{

    private Type type;


    public Type getType() {
        return type;
    }

    public GsonCallBack(Type type) {
        // TODO Auto-generated constructor stub
        this.type=type;
    }
    public GsonCallBack() {
        // TODO Auto-generated constructor stub
        //getClass().getGenericSuperclass()返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type
        //然后将其转换ParameterizedType。。
        //getActualTypeArguments()返回表示此类型实际类型参数的 Type 对象的数组。
        //[0]就是这个数组中第一个了。。
        //简而言之就是获得超类的泛型参数的实际类型。。
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            this.type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        } else {
            this.type = Object.class;
        }
    }



    @Override
    public void onSuccess(String json) {
        if (type instanceof Class) {
            String name =((Class) type).getSimpleName();
            if (name.equals(String.class.getSimpleName())||name.equals(Object.class.getSimpleName())) {
                onSuccessa((T) json);
                return;
            }
        }
        BaseBean baseBean=GsonUtils.getBeanFromJson(json,BaseBean.class);
        T t=GsonUtils.getBeanFromJson(baseBean.getData().toString(),type);
        LogUtils.e(t.toString());
        if (t != null) {
            onSuccessa(t);
        } else {

        }
    }

    public abstract void onSuccessa(T t);


}
