package com.myolq.frame.config;

/**
 * Created by root on 2017-08-25.
 */

public class RouterConfig {

    private   static  String URL="myall://";
    public final  static String LOGIN="login";
    public final static String REGISTER="register";

    public static String getLogin(){
        return URL+LOGIN;
    }
    public static String getRegister(){
        return URL+REGISTER;
    }

}
