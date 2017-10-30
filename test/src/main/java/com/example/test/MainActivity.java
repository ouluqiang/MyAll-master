package com.example.test;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.Response;
import com.myolq.frame.callback.StringCallBack;
import com.myolq.frame.loader.OkgoLoader;
import com.myolq.frame.utils.LogUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    String uploadPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        init();

        if (isSDCardEnable()){
            String path=getSDCardPath()+"新建.txt";
            boolean is=IsExist(path);
            Log.e("s",path+"--------"+is);
            uploadPath=path;
        }
        Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Log.e("sub","*****"+msg.toString());
            }
        };
        ArrivateUpload arrivateUpload=new ArrivateUpload("123456完全",uploadPath,handler);
        arrivateUpload.start();
    }


    /**
     * 判断SDCard是否可用
     *
     * @return
     */
    public static boolean isSDCardEnable()
    {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);

    }

    /**
     * 获取SD卡路径
     *
     * @return
     */
    public static String getSDCardPath()
    {
        return Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator;
    }

    public boolean IsExist(String path) {
        File file = new File(path);
        if (!file.exists())
            return false;
        else
            return true;
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void init(){
        /**
         * #	Result	Protocol	Host	URL	Body	Caching	Content-Type	Process	Comments	Custom
         312	200	HTTPS	apiv2.douyucdn.cn/lapi/member/sign/getSign?token=16176648_12_b5893112323f505b_1_16474110&client_sys=android	125		text/html; charset=UTF-8
         User-Device: ZTYxZGQ2ZTQtNjA1OC00N2RmLWExMzEtMjA0NTc0MGU2MmZhfHYyLjUuMC4x
         aid: android1
         auth: e0b0e8744e34b6dcaa4487522060402d
         time: 1505288566
         */
//        String url="https://apiv2.douyucdn.cn/lapi/member/sign/getSign?token=16176648_12_b5893112323f505b_1_16474110&client_sys=android";
//        HttpHeaders headers=new HttpHeaders();
//        headers.put("User-Device","ZTYxZGQ2ZTQtNjA1OC00N2RmLWExMzEtMjA0NTc0MGU2MmZhfHYyLjUuMC4x");
//        headers.put("aid","android1");
//        headers.put("auth","e0b0e8744e34b6dcaa4487522060402d");
//        headers.put("time","1505288566");
//        OkgoLoader.getInstance().sendByPostUploadingJson(url,headers , null, new StringCallBack() {
//            @Override
//            public void onSuccess(String s) {
//                LogUtils.i(s);
//            }
//
//            @Override
//            public void onError(Response response) {
//                LogUtils.i(response.toString());
//            }
//        });


        /**
         * #	Result	Protocol	Host	URL	Body	Caching	Content-Type	Process	Comments	Custom
         5	200	HTTPS	e1-api.leancloud.cn	/1.1/login	397	max-age=0, private, must-revalidate	application/json;charset=utf-8	noxvmhandle:10584
         X-LC-Id: I8FvRR1C4Jk1wFYF1AqXkqCq-9Nh9j0Va
         X-LC-Key: ihPu7rgeCIsnAlwyGUNwGhfp
         */
//        String url="https://e1-api.leancloud.cn/1.1/login";
//        HttpHeaders headers=new HttpHeaders();
//        headers.put("X-LC-Id","I8FvRR1C4Jk1wFYF1AqXkqCq-9Nh9j0Va");
//        headers.put("X-LC-Key","ihPu7rgeCIsnAlwyGUNwGhfp");
//
//        Map<String,String> map=new HashMap<>();
//        Map<String,String> m=new HashMap<>();
//        map.put("username","a123456");
//        map.put("password","123456");
//        OkgoLoader.getInstance().sendByPostUploadingJson(url ,headers, map, new StringCallBack() {
//            @Override
//            public void onSuccess(String s) {
//                LogUtils.i(s);
//            }
//
//            @Override
//            public void onError(Response response) {
//                LogUtils.i(response.toString());
//            }
//        });


        /**
         * #	Result	Protocol	Host	URL	Body	Caching	Content-Type	Process	Comments	Custom
         138	200	HTTPS	apiv2.douyucdn.cn/Live/Roomlist/getAllCateRoomList?offset=0&limit=20&client_sys=android	2,092		application/json	noxvmhandle:2572

         aid: android1
         auth: 89dd291e6c841cf68c23feddd4f7558c
         time: 1505373806
         User-Device: Y2NkNTEzMDAtYzkxYS00ZjI2LTg3ODYtNTk3MWIwY2U0OTkyfHYyLjUuNC4x

         #	Result	Protocol	Host	URL	Body	Caching	Content-Type	Process	Comments	Custom
         137	200	HTTPS	apiv2.douyucdn.cn	/live/TabCate/custom?client_sys=android	369		application/json	noxvmhandle:2572

         */

        //全部
        String url="https://apiv2.douyucdn.cn/Live/Roomlist/getAllCateRoomList?offset=0&limit=20&client_sys=android";
        //标题
//        String url="https://apiv2.douyucdn.cn/live/TabCate/custom?client_sys=android";
        HttpHeaders headers=new HttpHeaders();
        headers.put("aid","android1");
        headers.put("auth","89dd291e6c841cf68c23feddd4f7558c");
        headers.put("time","1505373806");
        headers.put("User-Device","Y2NkNTEzMDAtYzkxYS00ZjI2LTg3ODYtNTk3MWIwY2U0OTkyfHYyLjUuNC4x");

        OkgoLoader.getInstance().sendByGet(url ,headers, new StringCallBack() {
            @Override
            public void onSuccess(String s) {
                LogUtils.i(s);
            }

            @Override
            public void onError(Response response) {
                LogUtils.i(response.toString());
            }
        });
    }

}
