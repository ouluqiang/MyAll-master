package com.myolq.frame.config;

/**
 * Created by root on 2017-08-25.
 */

public class RouterConfig {

    private   static  String URL="myall://";
    public final  static String LOGIN="Login";
    public final static String REGISTER="Register";
    public final static String LAUNCH="Launch";
    public final static String HOME="Home";
    public final static String FORGET_PASSWORD="ForgetPassword";

    public static String getLogin(){
        return URL+LOGIN;
    }
    public static String getRegister(){
        return URL+REGISTER;
    }
    public static String getHome(){
        return URL+HOME;
    }
    public static String getForgetPassword(){
        return URL+FORGET_PASSWORD;
    }

}
