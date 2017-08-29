package com.myolq.frame.widget;

import android.content.Context;
import android.os.Handler;

import com.myolq.frame.R;
import com.myolq.frame.utils.DialogUtils;
import com.myolq.frame.utils.LogUtils;

/**
 * Created by root on 2017-08-28.
 */

public class LoadDialog {


    public static LoadDialog loadDialog;
    private long mPressedTime;

    private long time=10;
    private  Handler handler;

    public void setTime(long time) {
        this.time = time;
    }

    private Context context;
    private DialogUtils dialogUtils;

    private LoadDialog(Context context) {
        this.context=context;
        dialogUtils = DialogUtils.getInstance(context);
        dialogUtils.setView(R.layout.dialog_load);
        dialogUtils.setCancelable(false);
        if (handler==null)
            handler = new Handler();

    }

    public static LoadDialog getInstance(Context context){
        if (loadDialog==null){
            synchronized (DialogUtils.class){
                if (loadDialog==null){
                    loadDialog=new LoadDialog(context);
                }
            }
        }
        return loadDialog;
    }



    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            mPressedTime++;
            LogUtils.log(mPressedTime+"--");
            if (mPressedTime<=time){
                handler.postDelayed(runnable,1000);
            }else{
                cancel();
            }
        }
    };

    public void show(){
        dialogUtils.show();
        handler.post(runnable);
    }

    public void cancel(){
        mPressedTime=0;
        dialogUtils.cancel();
        handler.removeCallbacks(runnable);
    }


}
