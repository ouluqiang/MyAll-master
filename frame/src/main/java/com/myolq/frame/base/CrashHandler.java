package com.myolq.frame.base;

/**
 * Created by dell on 2017/11/7.
 */

import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;

import com.myolq.frame.utils.DialogUtils;
import com.myolq.frame.utils.LogUtils;

/**
 * UncaughtException处理类,当程序发生Uncaught异常的时候,有该类来接管程序,并记录发送错误报告.
 *
 *  需要在Application中注册，为了要在程序启动器就监控整个程序。
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {

    public static final String TAG = "CrashHandler";

    //系统默认的UncaughtException处理类
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    //CrashHandler实例
    private static CrashHandler instance;
    //程序的Context对象
    private Context mContext;

    public static boolean isShow=false;

    /** 保证只有一个CrashHandler实例 */
    private CrashHandler() {}

    /** 获取CrashHandler实例 ,单例模式 */
    public static CrashHandler getInstance() {
        if(instance == null)
            instance = new CrashHandler();
        return instance;
    }

    /**
     * 初始化
     */
    public void init(Context context) {
        mContext = context;
        //获取系统默认的UncaughtException处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        //设置该CrashHandler为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /**
     * 当UncaughtException发生时会转入该函数来处理
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (!handleException(ex) && mDefaultHandler != null) {
            //如果用户没有处理则让系统默认的异常处理器来处理
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            if (isShow){

            }
        }
    }

//    public void restartApp(){
////        Intent intent = new Intent(AppManager.getInstance().currentActivity(),WelcomeActivity.class);
////        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
////                | Intent.FLAG_ACTIVITY_CLEAR_TASK
////                | Intent.FLAG_ACTIVITY_NEW_TASK);
////        mContext.startActivity(intent);
////        android.os.Process.killProcess(android.os.Process.myPid());  //结束进程之前可以把你程序的注销或者退出代码放在这段代码之前
//    }

    /**
     * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成.
     *
     * @param ex
     * @return true:如果处理了该异常信息;否则返回false.
     */
    private boolean handleException(final Throwable ex) {
        if (ex == null) {
            return false;
        }
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                if (!isShow) {
                    LogUtils.e(ex);
                    new DialogUtils(AppManager.getInstance().currentActivity()).getCreate().setTitle( "很抱歉,程序出现异常,即将退出").setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
                }
                Looper.loop();
            }
        }.start();
        return true;
    }

//    private void crashLog(Throwable ex){
//        Writer writer = new StringWriter();
//        PrintWriter printWriter = new PrintWriter(writer);
//        ex.printStackTrace(printWriter);
//        Throwable cause = ex.getCause();
//        while (cause != null) {
//            cause.printStackTrace(printWriter);
//            cause = cause.getCause();
//        }
//        printWriter.close();
//        String result = writer.toString();
//        LogUtils.e("crash",result);
//    }

}
