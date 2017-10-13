package com.myolq.frame.base;

import android.app.Application;
import android.content.Context;

import com.github.mzule.activityrouter.annotation.Modules;
import com.github.mzule.activityrouter.annotation.Router;
import com.myolq.frame.loader.OkgoLoader;
import com.tencent.bugly.Bugly;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by Administrator on 2017/6/21.
 */

public class BaseApplication extends TinkerApplication {



//    private Context mContext;

    public BaseApplication() {
        super(ShareConstants.TINKER_ENABLE_ALL, "com.myolq.frame.base.BaseApplicationLike",
                "com.tencent.tinker.loader.TinkerLoader", false);

    }

//    @Override
//    public void onCreate() {
//        super.onCreate();
//        mContext=this;
//        OkgoLoader.getInstance().init(this);
////        Bugly.init(getApplicationContext(), "1a918d17d4", false);
//    }
//
//    public Context getApplicationContext() {
//        return mContext;
//    }

}

