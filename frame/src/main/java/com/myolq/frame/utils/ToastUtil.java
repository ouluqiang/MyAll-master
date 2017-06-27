package com.myolq.frame.utils;


import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;


/**
 * Toast显示消息
 *
 * @author
 */
public class ToastUtil {
    private static Toast mToast;
    public static final int TIME = 10000;// 显示时间

    /**
     * 显示信息
     *
     * @param context  (上下文)
     * @param message  (显示内容)
     * @param duration (显示时间)
     * @param gravity  (显示位置)
     */
    public static final void show(final Context context, final String message,
                                  int duration, int gravity) {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        mToast = Toast.makeText(context, message, duration);
        mToast.setGravity(gravity, 0, 0);
        mToast.show();
    }

    /**
     * 显示信息(默认底部显示)
     *
     * @param context  (上下文)
     * @param message  (显示内容)
     * @param duration (显示时间)
     */
    public static final void show(final Context context, final String message, int duration) {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        mToast = Toast.makeText(context, message, duration);
        mToast.show();
    }

    /**
     * 显示信息(默认底部显示,默认显示时间:Toast.LENGTH_SHORT)
     *
     * @param context (上下文)
     * @param message (显示内容)
     */
    public static final void show(final Context context, final String message) {
        show(context, message, Toast.LENGTH_SHORT);
    }

    /**
     * 显示信息(默认底部显示,默认显示时间:Toast.LENGTH_LONG)
     *
     * @param context (上下文)
     * @param message (显示内容)
     */
    public static final void showLong(final Context context, final String message) {
        show(context, message, Toast.LENGTH_LONG);
    }

    /**
     * 显示信息(默认中间显示,默认显示时间:Toast.LENGTH_SHORT)
     *
     * @param context
     * @param message
     */
    public static final void showCenter(final Context context,
                                        final String message) {
        show(context, message, Toast.LENGTH_SHORT, Gravity.CENTER);
    }

    /**
     * 显示信息(默认中间显示,默认显示时间:Toast.LENGTH_LONG)
     *
     * @param context
     * @param message
     */
    public static final void showCenterLong(final Context context,
                                            final String message) {
        show(context, message, Toast.LENGTH_LONG, Gravity.CENTER);
    }


}
