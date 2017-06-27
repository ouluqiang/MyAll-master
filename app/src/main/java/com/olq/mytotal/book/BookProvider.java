package com.olq.mytotal.book;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import com.myolq.frame.utils.FileUtils;
import com.olq.mytotal.bean.BookBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */

public class BookProvider {

    /**
     * 纯文本
     */
    public final static String TEXT_PLAIN = "text/plain";// （纯文本）
    /**
     * （HTML文档）
     */
    public final static String TEXT_HTML = "text/html";
    /**
     * （XHTML文档）
     */
    public final static String XHTML = "application/xhtml+xml";

    /**
     * （GIF图像）
     */
    public final static String GIF = "image/gif";
    /**
     * 【PHP中为：image/pjpeg】 （JPEG图像）
     */
    public final static String JPEG = "mage/jpeg";
    /**
     * （PNG图像）【PHP中为：image/x-png】
     */
    public final static String PNG = "image/png";
    /**
     * （MPEG动画）
     */
    public final static String MPEG = "video/mpeg";
    /**
     * （任意的二进制数据）
     */
    public final static String OCTET = "application/octet-stream";
    /**
     * （PDF文档）
     */
    public final static String PDF = "application/pdf";
    /**
     * （Microsoft Word文件）
     */
    public final static String WORD = "application/msword";
    /**
     * （RFC 822形式）
     */
    public final static String RFC = "message/rfc822";
    /**
     * （HTML邮件的HTML形式和纯文本形式，相同内容使用不同形式表示）
     */
    public final static String ALT = "multipart/alternative";
    /**
     * （使用HTTP的POST方法提交的表单）
     */
    public final static String FORM = "application/x-www-form-urlencoded";
    /**
     * （同上，但主要用于表单提交时伴随文件上传的场合）
     */
    public final static String FORM_DATA = "multipart/form-data";


    public static List<BookBean> scanMusicFile(Context context) {
        List<BookBean> books = new ArrayList<>();
        Cursor cursor = context.getContentResolver().query(
                Uri.parse("content://media/external/file"),
                new String[] { MediaStore.MediaColumns._ID,
                        MediaStore.MediaColumns.MIME_TYPE,
                        MediaStore.MediaColumns.SIZE,
                        MediaStore.MediaColumns.DATA }, MediaStore.MediaColumns.DATA+" like ? and "+ MediaStore.MediaColumns.SIZE+" >?",
                new String[] { "%.txt"," 1024" }
                , MediaStore.Images.Media.SIZE+" DESC");


        while (cursor.moveToNext()) {
            String id = cursor
                    .getString(cursor
                            .getColumnIndexOrThrow(MediaStore.Files.FileColumns._ID));
            String type = cursor.getString(cursor
                    .getColumnIndexOrThrow(MediaStore.Files.FileColumns.MIME_TYPE));
            Long size = cursor.getLong(cursor
                    .getColumnIndexOrThrow(MediaStore.Files.FileColumns.SIZE));

            String data = cursor.getString(cursor
                    .getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA));
            String title=data.substring(data.lastIndexOf("/")+1,data.lastIndexOf("."));

                Log.e("Name,Type,data", id+","+size + " ," + type + ", " + data+"---"+title);
            BookBean bookBean = new BookBean(data, FileUtils.formatFileSizeToString(size),title);
            books.add(bookBean);

        }
        return books;
    }

    /**
     * 返回指定类型的文件
     *
     *  types
     *            指定的类型
     */
    public static void  scanAllFile(Context context,String[] selectionArg) {
        String[] columns = new String[] { MediaStore.Files.FileColumns.TITLE,
                MediaStore.Files.FileColumns.DATA,MediaStore.Files.FileColumns.MIME_TYPE };

        Uri uri = MediaStore.Files.getContentUri("external");
        String selection =  MediaStore.Files.FileColumns.MIME_TYPE + "=?";

        Cursor c;
        c= context.getContentResolver().query(uri,
                columns, selection,selectionArg, null);
//        ArrayList<FileDetail> fileList = new ArrayList<FileDetail>();
        while(c.moveToNext()){
            String title = c.getString(c.getColumnIndexOrThrow(MediaStore.Files.FileColumns.TITLE));
            String data = c.getString(c.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA));
            String type = c.getString(c.getColumnIndexOrThrow(MediaStore.Files.FileColumns.MIME_TYPE));
//            FileDetail file = new FileDetail(title, type, data);
//            fileList.add(file);
        }
    }
}
