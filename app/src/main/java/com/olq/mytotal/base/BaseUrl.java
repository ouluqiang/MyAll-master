package com.olq.mytotal.base;

/**
 * Created by Administrator on 2017/2/8.
 */

public class BaseUrl {

   public static String URL="https://api.bmob.cn/";
    public static String CODE=URL+"1/";

    public static String USERS=CODE+"users";
    public static String LOGIN=CODE+"login";


    public static String getLogin(String username,String password){
        return LOGIN+"?username="+username+"&password="+password;
    }


}
