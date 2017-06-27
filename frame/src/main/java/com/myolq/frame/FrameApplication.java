package com.myolq.frame;

import android.app.Application;

import com.github.mzule.activityrouter.annotation.Modules;
import com.github.mzule.activityrouter.annotation.Router;
import com.myolq.frame.loader.OkgoLoader;

/**
 * Created by Administrator on 2017/6/21.
 */

public class FrameApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        OkgoLoader.getInstance().init(this);
    }
}
