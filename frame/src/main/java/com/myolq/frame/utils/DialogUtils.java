package com.myolq.frame.utils;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by root on 2017-08-28.
 */

public class DialogUtils {

    public static DialogUtils dialogUtils;
    private AlertDialog.Builder builder;
    private  AlertDialog dialog;
    private Context context;

    private DialogUtils(Context context) {
        this.context=context;
         builder= new AlertDialog.Builder(context);
    }

    public static DialogUtils getInstance(Context context){
        if (dialogUtils==null){
            synchronized (DialogUtils.class){
                if (dialogUtils==null){
                    dialogUtils=new DialogUtils(context);
                }
            }
        }
        return dialogUtils;
    }



    public View setView(int layout){

        View view=LayoutInflater.from(context).inflate(layout, null);
        builder.setView(layout);
        dialog=builder.create();
        return view;
    }

    public void show(){
        dialog.show();
    }
    public void cancel(){
        dialog.cancel();
    }

    public void setCancelable(boolean flag){
        dialog.setCancelable(flag);
    }



}
