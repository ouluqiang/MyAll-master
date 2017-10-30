package com.example.test;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dell on 2017/10/27.
 */

public class ArrivateUpload extends Thread {

    private final String BOUNDARYSTR = "--------aifudao7816510d1hq";
    private final String END = "\r\n";
    private final String LAST = "--";

    private String data;//表单数据
    private FileInputStream fis;//文件输入流
    private Handler handler;

    private String urlStr="http://192.168.2.93:8080/zdtd/operate/sendmail/a";
    private String mobile="12345678901";
    private String opinion="好啊好好";

    public ArrivateUpload(String data, String path, Handler handler) {
        this.data = data;
        this.handler = handler;
        try {
            this.fis=new FileInputStream(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            URL httpUrl=new URL(urlStr);
            HttpURLConnection connection= (HttpURLConnection) httpUrl.openConnection();
            connection.setRequestMethod("POST");//必须为post
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-type", "multipart/form-data;boundary=" + BOUNDARYSTR);//固定格式
            connection.setRequestProperty("Charset", "utf-8");  //设置编码
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            DataOutputStream dos=new DataOutputStream(connection.getOutputStream());
            StringBuffer sb=new StringBuffer();
            /**
             * 写入文本数据
             */

            sb.append(LAST+BOUNDARYSTR+END);
            sb.append("Content-Disposition: form-data; name=\"username\""+END+END);
            sb.append(data+END);//内容
            sb.append(LAST+BOUNDARYSTR+END);
            sb.append("Content-Disposition: form-data; name=\"mobile\""+END+END);
            sb.append(mobile+END);//内容
            sb.append(LAST+BOUNDARYSTR+END);
            sb.append("Content-Disposition: form-data; name=\"opinion\""+END+END);
            sb.append(opinion+END);//内容
            Log.e("sub",sb.toString());
            /**
             * 循环写入文件
             */
            sb.append(LAST+BOUNDARYSTR+END);
            sb.append("Content-Disposition:form-data;Content-Type:application/octet-stream;name=\"file1\";");
            sb.append("filename=\""+newString("新建.txt")+"\""+END+END);
            dos.write(sb.toString().getBytes("utf-8"));
            if (fis != null) {
                byte[] b=new byte[1024];
                int len;
                while ((len=fis.read(b))!=-1){
                    dos.write(b,0,len);
                }
                dos.write(END.getBytes());
            }
            dos.write((LAST+BOUNDARYSTR+LAST+END).getBytes());
            dos.flush();
            sb=new StringBuffer();
            if (connection.getResponseCode()==200) {//请求成功
                BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line=br.readLine())!=null){
                    sb.append(line);
                }
                Message msg= Message.obtain();
                JSONObject object=new JSONObject(sb.toString());
                handler.sendMessage(msg);
                Log.e("sub",object.toString());
            }
            Log.e("sub",connection.getResponseCode()+"--");

        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e("sub",e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("sub",e.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("sub",e.toString());
        }
    }

    public String newString(String s){
        String newS = newString(s,"UTF-8");
        return newS;
    }

    public String newString(String s,String u){
        String newS = null;
        try {
            newS= new String(s.getBytes(),u);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return newS;
    }
}

