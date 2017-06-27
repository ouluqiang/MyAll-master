package com.myolq.frame.loader;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static com.bumptech.glide.Glide.with;

/**
 * Created by Administrator on 2017/1/23.
 */

public class GlideLoader {

    public static GlideLoader mGlideLoader;

    private GlideLoader() {
    }

    public static GlideLoader getInstance(){
        if (mGlideLoader ==null){
            synchronized (GlideLoader.class){
                if (mGlideLoader==null){
                    mGlideLoader=new GlideLoader();
                }
            }
        }
        return mGlideLoader;
    }

    public void init(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).into(imageView);
    }

}
