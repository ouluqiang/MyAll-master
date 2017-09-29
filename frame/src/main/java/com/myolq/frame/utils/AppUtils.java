package com.myolq.frame.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/28.
 */

public class AppUtils {

    private AppUtils()
    {
		/* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");

    }

    private static Context mContext;
    private static Thread mUiThread;

    private static Handler sHandler = new Handler(Looper.getMainLooper());

    public static void init(Context context) {
        mContext = context;
        mUiThread = Thread.currentThread();
    }

    public static Context getAppContext() {
        return mContext;
    }

    /**
     * 获取应用程序名称
     */
    public static String getAppName(Context context)
    {
        try
        {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * [获取应用程序版本名称信息]
     *
     * @param context
     * @return 当前应用的版本名称 name
     */
    public static String getVersionName(Context context)
    {
        try
        {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;

        } catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  取到系统当前版本号 code
     * @param context
     * @return
     */
    public static int getsystemsion(Context context) {
        int systemversion = 0;
        // 取到系统当前版本号
        try {
            systemversion = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return systemversion;
    }

    /**
     * 检测某程序是否安装
     * @param context
     * @param packageName
     * @return
     */

    public static boolean isInstalledApp(Context context, String packageName)
    {
        Boolean flag = false;

        try
        {
            PackageManager pm = context.getPackageManager();
            List<PackageInfo> pkgs = pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
            for (PackageInfo pkg : pkgs)
            {
                // 当找到了名字和该包名相同的时候，返回
                if ((pkg.packageName).equals(packageName))
                {
                    return flag = true;
                }
            }
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return flag;
    }


    /**
     * 安装.apk文件
     *
     * @param context
     */
    public void install(Context context, String fileName)
    {
        if (TextUtils.isEmpty(fileName) || context == null)
        {
            return;
        }
        try
        {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setAction(android.content.Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(new File(fileName)), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 安装.apk文件
     *
     * @param context
     */
    public void install(Context context, File file)
    {
        try
        {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

//    private static String DEVICEKEY = "";

    /**
     * 根据mac地址+deviceid
     * 获取设备唯一编码
     * @return
     */
//    public static String getDeviceKey(Context context)
//    {
//        if ("".equals(DEVICEKEY))
//        {
//            String macAddress = "";
//            WifiManager wifiMgr = (WifiManager)context.getIns().getSystemService(context.WIFI_SERVICE);
//            WifiInfo info = (null == wifiMgr ? null : wifiMgr.getConnectionInfo());
//            if (null != info)
//            {
//                macAddress = info.getMacAddress();
//            }
//            TelephonyManager telephonyManager =
//                    (TelephonyManager)context.getIns().getSystemService(context.TELEPHONY_SERVICE);
//            String deviceId = telephonyManager.getDeviceId();
//            DEVICEKEY = MD5Util.toMD5("android" + Constant.APPKEY + Constant.APPPWD + macAddress + deviceId);
//        }
//        return DEVICEKEY;
//    }


    /**
     * 获取手机及SIM卡相关信息
     * @param context
     * @return
     */
    public static Map<String, String> getPhoneInfo(Context context) {
        Map<String, String> map = new HashMap<String, String>();
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String imei = tm.getDeviceId();
        String imsi = tm.getSubscriberId();
        String phoneMode = android.os.Build.MODEL;
        String phoneSDk = android.os.Build.VERSION.RELEASE;
        map.put("imei", imei);
        map.put("imsi", imsi);
        map.put("phoneMode", phoneMode+"##"+phoneSDk);
        map.put("model", phoneMode);
        map.put("sdk", phoneSDk);
        return map;
    }



}
