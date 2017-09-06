package com.myolq.frame.base;

import android.app.Application;
import android.content.Context;

import com.github.mzule.activityrouter.annotation.Modules;
import com.github.mzule.activityrouter.annotation.Router;
import com.myolq.frame.loader.OkgoLoader;

/**
 * Created by Administrator on 2017/6/21.
 */

public class BaseApplication extends Application{



    private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this.getApplicationContext();
        OkgoLoader.getInstance().init(this);
    }

    public Context getApplicationContext() {
        return mContext;
    }
}
