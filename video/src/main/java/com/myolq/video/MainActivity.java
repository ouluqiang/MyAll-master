package com.myolq.video;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.Response;
import com.myolq.frame.callback.StringCallBack;
import com.myolq.frame.loader.OkgoLoader;
import com.myolq.frame.utils.LogUtils;

public class MainActivity extends AppCompatActivity {

    String url="http://service.inke.com/api/live/aggregation?imsi=&uid=147970465&proto=6&idfa=3EDE83E7-9CD1-4186-9F37-EE77B7423265&lc=0000000000000027&cc=TG0001&imei=&sid=20tJHn0JsxdmOGkbNjpEjo3DIKFyoyboTrCjMvP7zNxofi1QNXT&cv=IK3.2.00_Iphone&devi=134a83cdf2e6701fa8f85c099c5e68ac3ea7bd4b&conn=Wifi&ua=Android%205s&idfv=5CCB6FE7-1F0F-4288-90DC-946D6F6C45C2&osversion=ios_9.300000&interest=1&location=0";
//    String url="http://service.inke.com/api/live/aggregation?imsi=&uid=147970465&proto=6&idfa=3EDE83E7-9CD1-4186-9F37-EE77B7423265&lc=0000000000000027&cc=TG0001&imei=&sid=20tJHn0JsxdmOGkbNjpEjo3DIKFyoyboTrCjMvP7zNxofi1QNXT&cv=IK3.2.00_Iphone&devi=134a83cdf2e6701fa8f85c099c5e68ac3ea7bd4b&conn=Wifi&ua=iPhone%205s&idfv=5CCB6FE7-1F0F-4288-90DC-946D6F6C45C2&osversion=ios_9.300000&interest=1&location=0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkgoLoader.getInstance().sendByGet(url, new StringCallBack() {
            @Override
            public void onSuccess(String s) {
                LogUtils.i(s);
            }

            @Override
            public void onError(Response response) {

            }
        });
    }
}
