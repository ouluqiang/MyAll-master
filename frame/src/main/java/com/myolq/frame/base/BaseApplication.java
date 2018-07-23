package com.myolq.frame.base;

import android.app.Application;
import android.content.Context;

import com.myolq.frame.loader.OkgoLoader;

/**
 * Created by Administrator on 2017/6/21.
 */

public class BaseApplication extends Application {



    public static final String TAG = "Tinker.BaseApplicationLike";
    private Context mContext;
    public Context getApplicationContext() {
        return mContext;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().init(mContext);
        OkgoLoader.getInstance().init(this);

//        // 设置是否开启热更新能力，默认为true
//        Beta.enableHotfix = true;
//        // 设置是否自动下载补丁，默认为true
//        Beta.canAutoDownloadPatch = true;
//        // 设置是否自动合成补丁，默认为true
//        Beta.canAutoPatch = true;
//        // 设置是否提示用户重启，默认为false
//        Beta.canNotifyUserRestart = false;
//        // 这里实现SDK初始化，appId替换成你的在Bugly平台申请的appId
//        // 调试时，将第三个参数改为true
//        //控制BuglySDK是否立即初始化（放到MainActivity里面初始化）
//        Beta.autoInit = false;
//        // 设置开发设备，默认为false，上传补丁如果下发范围指定为“开发设备”，需要调用此接口来标识开发设备
////        // 补丁回调接口
////        Beta.betaPatchListener = new BetaPatchListener() {
////            @Override
////            public void onPatchReceived(String patchFile) {
////                Toast.makeText(getApplication(), "补丁下载地址" + patchFile, Toast.LENGTH_SHORT).show();
////            }
////
////            @Override
////            public void onDownloadReceived(long savedLength, long totalLength) {
////                Toast.makeText(getApplication(),
////                        String.format(Locale.getDefault(), "%s %d%%",
////                                Beta.strNotificationDownloading,
////                                (int) (totalLength == 0 ? 0 : savedLength * 100 / totalLength)),
////                        Toast.LENGTH_SHORT).show();
////            }
////
////            @Override
////            public void onDownloadSuccess(String msg) {
////                Toast.makeText(getApplication(), "补丁下载成功", Toast.LENGTH_SHORT).show();
////            }
////
////            @Override
////            public void onDownloadFailure(String msg) {
////                Toast.makeText(getApplication(), "补丁下载失败", Toast.LENGTH_SHORT).show();
////
////            }
////
////            @Override
////            public void onApplySuccess(String msg) {
////                Toast.makeText(getApplication(), "补丁应用成功", Toast.LENGTH_SHORT).show();
////            }
////
////            @Override
////            public void onApplyFailure(String msg) {
////
////                Toast.makeText(getApplication(), "补丁应用失败", Toast.LENGTH_SHORT).show();
////            }
////
////            @Override
////            public void onPatchRollback() {
////                Toast.makeText(getApplication(), "onPatchRollback", Toast.LENGTH_SHORT).show();
////            }
////        };
    }




}

