package com.myolq.frame.config;

import android.content.Context;

import com.myolq.frame.utils.SpUtils;

/**
 * Created by root on 2017-09-04.
 */

public class UserConfig {

   private static String fileName="user";

    private static String sessionKey="session";

    private static boolean emailVerified;
    private static String boy;
    private static String email;
    private static String objectId;
    private static String username;


    public static void setSession(Context context,String session){
        SpUtils.save(context,fileName,sessionKey,session);
    }

    public static String getSession(Context context){
        return (String) SpUtils.get(context,fileName,sessionKey,"");
    }
    public static void clearUser(Context context){
         SpUtils.clear(context,fileName);
    }




    public static void setUser(String objectId, String username, String boy, String email, boolean emailVerified){
        UserConfig.objectId =objectId;
        UserConfig.username=username;
        UserConfig.boy=boy;
        UserConfig.email=email;
        UserConfig.emailVerified=emailVerified;
    }

    public static boolean isEmailVerified() {
        return emailVerified;
    }

    public static String getBoy() {
        return boy;
    }

    public static String getEmail() {
        return email;
    }

    public static String getObjectId() {
        return objectId;
    }

    public static String getUsername() {
        return username;
    }

}
