package com.myolq.frame.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by root on 2017-08-28.
 */

public class DialogUtils {

//    public static DialogUtils dialogUtils;
    private AlertDialog.Builder builder;
    private  AlertDialog dialog;
    private Context context;

    public DialogUtils(Context context) {
        this.context=context;
         builder= new AlertDialog.Builder(context);
    }

//    public static DialogUtils getInstance(Context context){
//        if (dialogUtils==null){
//            synchronized (DialogUtils.class){
//                if (dialogUtils==null){
//                    dialogUtils=new DialogUtils(context);
//                }
//            }
//        }
//        return dialogUtils;
//    }



    public View setView(int layout){

        View view=LayoutInflater.from(context).inflate(layout, null);
        builder.setView(view);
        dialog=builder.create();
        return view;
    }

    public void show(){
        if (dialog!=null)
            dialog.show();
    }
    public void cancel(){
        if (dialog!=null) {
            dialog.cancel();
            dialog = null;
        }
    }

    public DialogUtils getCreate(){
        dialog=builder.create();
        return this;
    }
    public DialogUtils setCancelable(boolean flag){
        getCreate();
        dialog.setCancelable(flag);
        return this;
    }

    public DialogUtils setTitle(CharSequence charSequence){
        builder.setTitle(charSequence);
        return this;
    }
    public DialogUtils setMessage(CharSequence charSequence){
        builder.setMessage(charSequence);
        return this;
    }

    public DialogUtils setNegativeButton(String s,DialogInterface.OnClickListener call){
        builder.setNegativeButton(s,call);
        return this;
    }
    public DialogUtils setPositiveButton(String s,DialogInterface.OnClickListener call){
        builder.setPositiveButton(s,call);
        return this;
    }



}
