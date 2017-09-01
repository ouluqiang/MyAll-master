package com.myolq.mvp;

import android.content.Context;
import android.net.Uri;

import com.github.mzule.activityrouter.annotation.Modules;
import com.github.mzule.activityrouter.router.RouterCallback;
import com.github.mzule.activityrouter.router.RouterCallbackProvider;
import com.github.mzule.activityrouter.router.SimpleRouterCallback;
import com.myolq.frame.BaseApplication;
import com.myolq.frame.utils.LogUtils;

/**
 * Created by root on 2017-08-28.
 */

@Modules({"app","user","home"})
public class InitApplication extends BaseApplication  {

}
