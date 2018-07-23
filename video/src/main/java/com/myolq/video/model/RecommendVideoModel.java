package com.myolq.video.model;

import com.myolq.frame.loader.callback.GsonCallBack;
import com.myolq.frame.loader.OkgoLoader;
import com.myolq.video.bean.VideoBean;
import com.myolq.video.contract.RecommendVideoContract;

/**
 * Created by root on 2017-08-24.
 */

public class RecommendVideoModel implements RecommendVideoContract.Model{


    @Override
    public void getRecommendVideo( GsonCallBack<VideoBean> callBack) {
//        String url = "http://service.inke.com/api/live/aggregation?imsi=&uid=147970465&proto=6&idfa=3EDE83E7-9CD1-4186-9F37-EE77B7423265&lc=0000000000000027&cc=TG0001&imei=&sid=20tJHn0JsxdmOGkbNjpEjo3DIKFyoyboTrCjMvP7zNxofi1QNXT&cv=IK3.2.00_Iphone&devi=134a83cdf2e6701fa8f85c099c5e68ac3ea7bd4b&conn=Wifi&ua=Android%205s&idfv=5CCB6FE7-1F0F-4288-90DC-946D6F6C45C2&osversion=ios_9.300000&interest=1&location=0";
        String url="http://service.inke.com/api/live/aggregation?uid=147970465&interest=1&location=0";
        OkgoLoader.getInstance().sendByGet(url,callBack);
    }
}
