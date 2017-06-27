package com.myolq.frame.callback;

import java.io.File;

/**
 * Created by Administrator on 2017/1/23.
 */

public abstract class FileCallBack extends HttpCallBack<File>{

    public abstract void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed);
        //这里回调下载进度(该回调在主线程,可以直接更新ui)

}
