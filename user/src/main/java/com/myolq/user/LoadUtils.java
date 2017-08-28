package com.myolq.user;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.myolq.frame.utils.LogUtils;

/**
 * Created by root on 2017-08-28.
 */

public class LoadUtils {


    public static LoadUtils loadUtils;
    private long mPressedTime;

    private long time=10;
    private  Handler handler;

    public void setTime(long time) {
        this.time = time;
    }

    private Context context;
    private DialogUtils dialogUtils;

    private LoadUtils(Context context) {
        this.context=context;
        dialogUtils = DialogUtils.getInstance(context);
        dialogUtils.setView(R.layout.dialog_load);
        dialogUtils.setCancelable(false);
        if (handler==null)
            handler = new Handler();

    }

    public static LoadUtils getInstance(Context context){
        if (loadUtils==null){
            synchronized (DialogUtils.class){
                if (loadUtils==null){
                    loadUtils=new LoadUtils(context);
                }
            }
        }
        return loadUtils;
    }



    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            mPressedTime++;
            LogUtils.log(mPressedTime+"--");
            if (mPressedTime<=time){
                handler.postDelayed(runnable,1000);
            }else{
                remove();
            }
        }
    };

    public void show(){
        dialogUtils.show();
        handler.post(runnable);
    }

    public void remove(){
        mPressedTime=0;
        dialogUtils.cancel();
        handler.removeCallbacks(runnable);
    }


}
