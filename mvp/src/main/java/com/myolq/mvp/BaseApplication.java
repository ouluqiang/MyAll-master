package com.myolq.mvp;

import android.app.Application;

import com.github.mzule.activityrouter.annotation.Modules;
import com.myolq.frame.FrameApplication;
import com.myolq.frame.loader.OkgoLoader;

/**
 * Created by Administrator on 2017/6/19.
 */

@Modules({"app","user","home","book"})
public class BaseApplication extends FrameApplication{

    @Override
    public void onCreate() {
        super.onCreate();
        OkgoLoader.getInstance().init(this);
    }
}
