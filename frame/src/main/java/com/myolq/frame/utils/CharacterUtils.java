package com.myolq.frame.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;

/**
 * Created by Administrator on 2017/2/15.
 */

public class CharacterUtils {


    /**
     * 是否为空
     * @param text
     * @return
     */
    public static boolean isEmpty(CharSequence text) {
        return TextUtils.isEmpty(text);
    }

    /**
     * 是否匹配
     * @param text
     * @param text1
     * @return
     */
    public static boolean equals(CharSequence text, CharSequence text1) {
        return TextUtils.equals(text, text1);
    }

    /**
     * string长度大于某个值
     * @param text
     * @param length
     * @return
     */
    public static boolean isLengthEquals(CharSequence text, float length) {
        return text.length() == length ? true : false;
    }

    /**
     * string长度大于某个值
     * @param text
     * @param length
     * @return
     */
    public static boolean isLengthMin(CharSequence text, float length) {
        return text.length() >= length ? true : false;
    }

    /**
     * string长度小于某个值
     * @param text
     * @param length
     * @return
     */
    public static boolean isLengthMax(CharSequence text, int length) {
        return text.length() < length ? true : false;
    }

    /**
     * string长度在2个值中间
     * @param text
     * @param start
     * @param end
     * @return
     */
    public static boolean isLengthMinAndMax(CharSequence text, int start, int end) {
        return text.length() < end && text.length() > start ? true : false;
    }

    /**
     * dimen沒有单位的值
     */
    public static float getDimension(Context context, int dimen){
        TypedValue typedValue=new TypedValue();
        context.getResources().getValue(dimen,typedValue,true);
        return typedValue.getFloat();
    }

}
