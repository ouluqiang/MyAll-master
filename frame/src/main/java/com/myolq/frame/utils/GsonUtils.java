package com.myolq.frame.utils;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2017/1/23.
 */

public class GsonUtils {

    private static Gson gson=new Gson();

    //解析json数据
//    public  <T> T getBeanFromJson(String json, Class<T> clazz){
//        return new Gson().fromJson(json, new ParameterizedTypeImpl());
//    }


    public static <T> T getBeanFromJson(String json,Type type){
        return gson.fromJson(json, type);
    }

    public static <T> T getBeanFromJson(String json,Class<T> clazz){
//        Type type = TypeBuilder
//                .newInstance(clazz)
//                .addTypeParam(clazz)
//                .build();
        Type type=new ParameterizedTypeImpl(clazz,new Class[]{clazz});
        return gson.fromJson(json,type);
//        return gson.fromJson(json, clazz);
    }

    //根据泛型返回解析制定的类型
    public static <T> T fromToJson(String json){
        Type type = new com.google.gson.reflect.TypeToken<T>(){}.getType();
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }



    //对象转换成json数据
    public static String getBeanToJson(Object json)
    {
        return gson.toJson(json);
    }


    static class ParameterizedTypeImpl implements ParameterizedType {

        Class clazz;
        Type[] types;

        ParameterizedTypeImpl(Class clazz,Type[] types){
            this.clazz=clazz;
            this.types=types!=null?types:new Type[0];
        }

        @Override
        public Type[] getActualTypeArguments() {
            return  types;
        }

        @Override
        public Type getRawType() {
            return clazz;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }

}
