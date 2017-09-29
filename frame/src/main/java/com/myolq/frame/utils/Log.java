package com.myolq.frame.utils;

/**
 * Created by root on 2017-09-26.
 */

public class Log {

    /**
     *
     1、跳转到拨号界面，代码如下：
     1）直接拨打
     Intent intentPhone = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
     startActivity(intentPhone);

     2）跳转到拨号界面
     Intent intent = newIntent(Intent.ACTION_DIAL,Uri.parse("tel:" + phoneNumber));
     intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
     startActivity(intent);
     2、跳转到联系人页面，使用一下代码：
     Intent intentPhone = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
     startActivity(intentPhone);
     //安装已经存在的apk
     String filePath="mnt/sdcard/abc.apk";
     Intent intent = new Intent(Intent.ACTION_VIEW);
     intent.setDataAndType(Uri.parse("file://" + filePath),
     "application/vnd.Android.package-archive");
     startActivity(intent);//直接跳到安装页面，但是还要点击按钮确定安装，还是取消安装
     //卸载某应用
     String packageName="org.adw.launcher2"
     Uri packageUri = Uri.parse("package:"+packageName);//包名，指定该应用
     Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageUri);
     startActivity(uninstallIntent);
     //查看某一应用程序的信息
     Uri uri=Uri.parse("package:"+packageName);//包名，指定该应用
     Intent intent=new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", uri);
     startActivity(intent);
     2.浏览网页某一具体网址
     Uri uri = Uri.parse("http://xxxxxxxxxxxxxxxxxxxxxxxx");
     Intent intent  = new Intent(Intent.ACTION_VIEW,uri);
     //加下面这句话就是启动系统自带的浏览器打开上面的网址， 不加下面一句话， 如果你有多个浏览器，就会弹出让你选择某一浏览器， 然后改浏览器就会打开该网址...............
     intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
     startActivity(intent);
     //系统 设置 界面
     Intent intent=new Intent();
     intent.setClassName("com.android.settings","com.android.settings.Settings");
     startActivity(intent);
     //回到桌面吗
     Intent intent = new Intent(Intent.ACTION_MAIN);
     intent.addCategory(Intent.CATEGORY_HOME);
     startActivity(intent);
     //系统  拨号  界面
     Intent intent= new Intent(Intent.ACTION_DIAL);
     intent.setClassName("com.android.contacts","com.android.contacts.DialtactsActivity");
     startActivity(intent);
     //系统 通话记录 界面
     Intent intent =new Intent();
     intent.setAction("android.intent.action.CALL_BUTTON");
     startActivity(intent);
     //拨号
     Uri uri = Uri.parse("tel:xxxxxx");
     Intent intent = new Intent(Intent.ACTION_DIAL, uri);
     startActivity(intent);
     //启动拨号界面，指定了类名 包名  是系统的拨号界面  DialtactsActivity
     Intent intent= new Intent("android.intent.action.DIAL");
     intent.setClassName("com.android.contacts","com.android.contacts.DialtactsActivity");
     startActivity(intent);
     //系统 联系人 界面  PeopleActivity
     Intent intent001 = new Intent();
     intent001.setClassName("com.android.contacts","com.android.contacts.activities.PeopleActivity");
     startActivity(intent001);
     //系统 搜索  界面  SearchActivity
     Intent intent002=new Intent();
     intent002.setClassName("com.android.quicksearchbox", "com.android.quicksearchbox.SearchActivity");
     startActivity(intent002);
     //启动短信收件箱的界面,指定了包名，类名
     Intent intent4 = new Intent();
     intent4.setClassName("com.android.mms","com.android.mms.ui.ConversationList");
     startActivity(intent4);
     //启动联系人界面，不好
     Intent intent = new Intent();
     intent.setAction(Intent.ACTION_PICK);
     intent.setData(Contacts.People.CONTENT_URI);
     startActivity(intent);
     插入联系人
     Intent intent=newIntent(Intent.ACTION_EDIT,Uri.parse("content://com.android.contacts/contacts/"+"1"));
     startActivity(intent);
     到联系人列表界面
     Intent intent = new Intent(Intent.ACTION_INSERT_OR_EDIT);
     intent.setType("vnd.android.cursor.item/person");
     intent.setType("vnd.android.cursor.item/contact");
     intent.setType("vnd.android.cursor.item/raw_contact");
     intent.putExtra(android.provider.ContactsContract.Intents.Insert.NAME, name);
     intent.putExtra(android.provider.ContactsContract.Intents.Insert.COMPANY,company);
     intent.putExtra(android.provider.ContactsContract.Intents.Insert.PHONE, tel);
     intent.putExtra(android.provider.ContactsContract.Intents.Insert.PHONE_TYPE, 3);
     //启动短信收件箱的界面,指定了包名，类名
     Intent intent = new Intent();
     intent.setClassName("com.android.mms","com.android.mms.ui.ConversationList");
     startActivity(intent);
     //启动编辑短信的界面
     Intent intent = new Intent(Intent.ACTION_VIEW);
     intent.setType("vnd.android-dir/mms-sms");
     // intent.setData(Uri.parse("content://mms-sms/conversations/"));//此为号码
     startActivity(intent);
     ---------------------------------------------------------------
     2---------------------------------------------------------------
     ---------------------------------------------------------------
     现在开发中的功能需要直接跳转到拨号、联系人、短信界面等等，查找了很多资料，自己整理了一下。
     首先，我们先看拨号界面，代码如下：
     Intent intent =new Intent();
     intent.setAction("android.intent.action.CALL_BUTTON");
     startActivity(intent);
     和
     Uri uri = Uri.parse("tel:xxxxxx");
     Intent intent = new Intent(Intent.ACTION_DIAL, uri);
     startActivity(intent);
     两者都行
     但是如果是跳转到应用,使用一下代码：
     Intent intent= new Intent("android.intent.action.DIAL");
     intent.setClassName("com.android.contacts","com.android.contacts.DialtactsActivity");
     到通话记录界面：
     Intent intent=new Intent();
     intent.setAction(Intent.ACTION_CALL_BUTTON);
     startActivity(intent);
     到联系人界面：
     Intent intent = new Intent();
     intent.setAction(Intent.ACTION_VIEW);
     intent.setData(Contacts.People.CONTENT_URI);
     startActivity(intent);
     到应用：
     Intent intent= new Intent("com.android.contacts.action.LIST_STREQUENT");
     intent.setClassName("com.android.contacts","com.android.contacts.DialtactsActivity");
     调用联系人界面：
     Intent intent = new Intent();
     intent.setAction(Intent.ACTION_PICK);
     intent.setData(Contacts.People.CONTENT_URI);
     startActivity(intent);
     插入联系人
     Intent intent=new Intent(Intent.ACTION_EDIT,Uri.parse("content://com.android.contacts/contacts/"+"1"));
     startActivity(intent);
     到联系人列表界面
     Intent intent = new Intent(Intent.ACTION_INSERT_OR_EDIT);
     intent.setType("vnd.android.cursor.item/person");
     intent.setType("vnd.android.cursor.item/contact");
     intent.setType("vnd.android.cursor.item/raw_contact");
     intent.putExtra(android.provider.ContactsContract.Intents.Insert.NAME, name);
     intent.putExtra(android.provider.ContactsContract.Intents.Insert.COMPANY,company);
     intent.putExtra(android.provider.ContactsContract.Intents.Insert.PHONE, tel);
     intent.putExtra(android.provider.ContactsContract.Intents.Insert.PHONE_TYPE, 3);
     复制代码
     到短信界面：
     Intent intent = new Intent(Intent.ACTION_VIEW);
     intent.setType("vnd.android-dir/mms-sms");
     //intent.setData(Uri.parse("content://mms-sms/conversations/"));//此为号码
     startActivity(intent);
     到应用：
     Intent intent = new Intent("android.intent.action.CONVERSATION");
     startActivity(intent);
     以下是在网上找到的其他方法：
     1.从google搜索内容
     Intent intent = new Intent();
     intent.setAction(Intent.ACTION_WEB_SEARCH);
     intent.putExtra(SearchManager.QUERY,"searchString")
     startActivity(intent);
     2.浏览网页
     Uri uri = Uri.parse("http://www.google.com");
     Intent it  = new Intent(Intent.ACTION_VIEW,uri);
     startActivity(it);
     3.显示地图
     Uri uri = Uri.parse("geo:38.899533,-77.036476");
     Intent it = new Intent(Intent.Action_VIEW,uri);
     startActivity(it);
     4.路径规划
     Uri uri = Uri.parse("http://maps.google.com/maps?f=dsaddr=startLat%20startLng&daddr=endLat%20endLng&hl=en");
     Intent it = new Intent(Intent.ACTION_VIEW,URI);
     startActivity(it);
     5.拨打电话
     Uri uri = Uri.parse("tel:xxxxxx");
     Intent it = new Intent(Intent.ACTION_DIAL, uri);
     startActivity(it);
     和
     uri = Uri.parse("tel:"+number);
     intent = new Intent(Intent.ACTION_CALL,uri);
     startActivity(intent);
     其中不同自己试验一下就知道了。
     6.调用发短信的程序
     Intent it = new Intent(Intent.ACTION_VIEW);
     it.putExtra("sms_body", "The SMS text");
     it.setType("vnd.android-dir/mms-sms");
     startActivity(it);
     和
     uri = Uri.parse("smsto:"+要发送短信的对方的number);
     intent = new Intent(Intent.ACTION_SENDTO,uri);
     startActivity(intent);
     和
     mIntent = new Intent(Intent.ACTION_VIEW);
     mIntent.putExtra("address", c.getString(c.getColumnIndex(column)));
     mIntent.setType("vnd.android-dir/mms-sms");
     startActivity(mIntent);
     7.发送短信
     Uri uri = Uri.parse("smsto:0800000123");
     Intent it = new Intent(Intent.ACTION_SENDTO, uri);
     it.putExtra("sms_body", "The SMS text");
     startActivity(it);
     String body="this is sms demo";
     Intent mmsintent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("smsto", number, null));
     mmsintent.putExtra(Messaging.KEY_ACTION_SENDTO_MESSAGE_BODY, body);
     mmsintent.putExtra(Messaging.KEY_ACTION_SENDTO_COMPOSE_MODE, true);
     mmsintent.putExtra(Messaging.KEY_ACTION_SENDTO_EXIT_ON_SENT, true);
     startActivity(mmsintent);<span style="font-family:Simsun;white-space: normal; background-color: rgb(255, 255, 255);"> </span>
     8.发送彩信
     Uri uri = Uri.parse("content://media/external/images/media/23");
     Intent it = new Intent(Intent.ACTION_SEND);
     it.putExtra("sms_body", "some text");
     it.putExtra(Intent.EXTRA_STREAM, uri);
     it.setType("image/png");
     startActivity(it);
     StringBuilder sb = new StringBuilder();
     sb.append("file://");
     sb.append(fd.getAbsoluteFile());
     Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mmsto", number, null));
     // Below extra datas are all optional.
     intent.putExtra(Messaging.KEY_ACTION_SENDTO_MESSAGE_SUBJECT, subject);
     intent.putExtra(Messaging.KEY_ACTION_SENDTO_MESSAGE_BODY, body);
     intent.putExtra(Messaging.KEY_ACTION_SENDTO_CONTENT_URI, sb.toString());
     intent.putExtra(Messaging.KEY_ACTION_SENDTO_COMPOSE_MODE, composeMode);
     intent.putExtra(Messaging.KEY_ACTION_SENDTO_EXIT_ON_SENT, exitOnSent);
     startActivity(intent);
     9.发送Email
     Uri uri = Uri.parse("mailto:xxx@abc.com");
     Intent it = new Intent(Intent.ACTION_SENDTO, uri);
     startActivity(it);
     Intent it = new Intent(Intent.ACTION_SEND);
     it.putExtra(Intent.EXTRA_EMAIL, "me@abc.com");
     it.putExtra(Intent.EXTRA_TEXT, "The email body text");
     it.setType("text/plain");
     startActivity(Intent.createChooser(it, "Choose Email Client"));
     Intent it=new Intent(Intent.ACTION_SEND);
     String[] tos={"me@abc.com"};
     String[] ccs={"you@abc.com"};
     it.putExtra(Intent.EXTRA_EMAIL, tos);
     it.putExtra(Intent.EXTRA_CC, ccs);
     it.putExtra(Intent.EXTRA_TEXT, "The email body text");
     it.putExtra(Intent.EXTRA_SUBJECT, "The email subject text");
     it.setType("message/rfc822");
     startActivity(Intent.createChooser(it, "Choose Email Client"));
     Intent it = new Intent(Intent.ACTION_SEND);
     it.putExtra(Intent.EXTRA_SUBJECT, "The email subject text");
     it.putExtra(Intent.EXTRA_STREAM, "file:///sdcard/mysong.mp3");
     sendIntent.setType("audio/mp3");
     startActivity(Intent.createChooser(it, "Choose Email Client"));
     10.播放多媒体
     Intent it = new Intent(Intent.ACTION_VIEW);
     Uri uri = Uri.parse("file:///sdcard/song.mp3");
     it.setDataAndType(uri, "audio/mp3");
     startActivity(it);
     Uri uri = Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "1");
     Intent it = new Intent(Intent.ACTION_VIEW, uri);
     startActivity(it);
     11.uninstall apk
     Uri uri = Uri.fromParts("package", strPackageName, null);
     Intent it = new Intent(Intent.ACTION_DELETE, uri);
     startActivity(it);
     12.install apk
     Uri installUri = Uri.fromParts("package", "xxx", null);
     returnIt = new Intent(Intent.ACTION_PACKAGE_ADDED, installUri);
     13. 打开照相机
     <1>Intent i = new Intent(Intent.ACTION_CAMERA_BUTTON, null);
     this.sendBroadcast(i);
     <2>long dateTaken = System.currentTimeMillis();
     String name = createName(dateTaken) + ".jpg";
     fileName = folder + name;
     ContentValues values = new ContentValues();
     values.put(Images.Media.TITLE, fileName);
     values.put("_data", fileName);
     values.put(Images.Media.PICASA_ID, fileName);
     values.put(Images.Media.DISPLAY_NAME, fileName);
     values.put(Images.Media.DESCRIPTION, fileName);
     values.put(Images.ImageColumns.BUCKET_DISPLAY_NAME, fileName);
     Uri photoUri = getContentResolver().insert(
     MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
     Intent inttPhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
     inttPhoto.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
     startActivityForResult(inttPhoto, 10);
     14.从gallery选取图片
     Intent i = new Intent();
     i.setType("image/*");
     i.setAction(Intent.ACTION_GET_CONTENT);
     startActivityForResult(i, 11);
     15. 打开录音机
     Intent mi = new Intent(Media.RECORD_SOUND_ACTION);
     startActivity(mi);
     16.显示应用详细列表
     Uri uri = Uri.parse("market://details?id=app_id");
     Intent it = new Intent(Intent.ACTION_VIEW, uri);
     startActivity(it);
     //where app_id is the application ID, find the ID
     //by clicking on your application on Market home
     //page, and notice the ID from the address bar<span style="font-family:Simsun;white-space: normal; background-color: rgb(255, 255, 255);">  </span>
     刚才找app id未果，结果发现用package name也可以 Uri uri = Uri.parse("market://details?id=<packagename>");
     这个简单多了
     17寻找应用
     Uri uri = Uri.parse("market://search?q=pname:pkg_name");
     Intent it = new Intent(Intent.ACTION_VIEW, uri);
     startActivity(it);
     //where pkg_name is the full package path for an application<span style="font-family:Simsun;white-space: normal; background-color: rgb(255, 255, 255);">   </span>
     18打开联系人列表
     Intent i = new Intent();
     i.setAction(Intent.ACTION_GET_CONTENT);
     i.setType("vnd.android.cursor.item/phone");
     startActivityForResult(i, REQUEST_TEXT);
     Uri uri = Uri.parse("content://contacts/people");
     Intent it = new Intent(Intent.ACTION_PICK, uri);
     startActivityForResult(it, REQUEST_TEXT);
     19 打开另一程序
     Intent i = new Intent();
     ComponentName cn = new ComponentName("com.yellowbook.android2",  "com.yellowbook.android2.AndroidSearch");
     i.setComponent(cn);
     i.setAction("android.intent.action.MAIN");
     startActivityForResult(i, RESULT_OK);
     20 添加到短信收件箱
     ContentValues cv = new ContentValues();
     cv.put("type", "1");
     cv.put("address","短信地址");
     cv.put("body", "短信内容");
     getContentResolver().insert(Uri.parse("content://sms/inbox"), cv);
     21 从sim卡或者联系人中查询
     Cursor cursor;
     Uri uri;
     if (type == 1) {
     Intent intent = new Intent();
     intent.setData(Uri.parse("content://icc/adn"));
     uri = intent.getData();
     } else
     uri = People.CONTENT_URI;
     cursor = activity.getContentResolver().query(uri, null, null, null, null);
     while (cursor.moveToNext()) {
     int peopleId = cursor.getColumnIndex(People._ID);
     int nameId = cursor.getColumnIndex(People.NAME);
     int phoneId = cursor.getColumnIndex(People.NUMBER);}
     查看某个联系人，当然这里是ACTION_VIEW，如果为选择并返回action改为ACTION_PICK，当然处理intent时返回需要用到 startActivityforResult
     Uri personUri = ContentUris.withAppendedId(People.CONTENT_URI, ID);//最后的ID参数为联系人Provider中的数据库BaseID，即哪一行
     Intent intent = new Intent(); intent.setAction(Intent.ACTION_VIEW); intent.setData(personUri); startActivity(intent);
     22 删除
     uri = ContentUris.withAppendedId(People.CONTENT_URI, 联系人id);
     int count = activity.getContentResolver().delete(uri, null, null
     23 添加到联系人：
     ContentValues cv = new ContentValues();
     ArrayList<ContentProviderOperation> operationList = new ArrayList<ContentProviderOperation>();
     ContentProviderOperation.Builder builder = ContentProviderOperation.newInsert(RawContacts.CONTENT_URI);
     builder.withValues(cv);
     operationList.add(builder.build());
     builder = ContentProviderOperation.newInsert(Data.CONTENT_URI);
     builder.withValueBackReference(StructuredName.RAW_CONTACT_ID, 0);
     builder.withValue(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
     builder.withValue(StructuredName.DISPLAY_NAME, "自定义联系人名");
     operationList.add(builder.build());
     builder = ContentProviderOperation.newInsert(Data.CONTENT_URI);
     builder.withValueBackReference(Phone.RAW_CONTACT_ID, 0);
     builder.withValue(Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
     builder.withValue(Phone.NUMBER, "联系人的phonenumber");
     builder.withValue(Data.IS_PRIMARY, 1);
     operationList.add(builder.build());
     try {
     getContentResolver().applyBatch(ContactsContract.AUTHORITY, operationList);
     } catch (RemoteException e) {
     e.printStackTrace();
     } catch (OperationApplicationException e) {
     e.printStackTrace();
     }
     23 选择一个图片
     Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
     intent.addCategory(Intent.CATEGORY_OPENABLE);
     intent.setType("image/*");
     startActivityForResult(intent, 0);
     24 调用Android设备的照相机，并设置拍照后存放位置
     Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
     intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment .getExternalStorageDirectory().getAbsolutePath()+"/cwj", android123 + ".jpg"))); //存放位置为sdcard卡上cwj文件夹，文件名为android123.jpg格式
     startActivityForResult(intent, 0);
     25 在market上搜索指定package name，比如搜索com.android123.cwj的写法如下
     Uri uri = Uri.parse("market://search?q=pname:com.android123.cwj");
     Intent intent = new Intent(Intent.ACTION_VIEW, uri); startActivity(intent);
     26获取文件信息，并使用相对应软件打开
     private void openFile(File f)
     {
     Intent intent = new Intent();
     intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
     intent.setAction(android.content.Intent.ACTION_VIEW);
     String type = getMIMEType(f);
     intent.setDataAndType(Uri.fromFile(f), type);
     startActivity(intent);
     }
     private String getMIMEType(File f){
     String end = f .getName() .substring(f.getName().lastIndexOf(".") + 1,f.getName().length()).toLowerCase();
     String type = "";
     if (end.equals("mp3") || end.equals("aac") || end.equals("aac")|| end.equals("amr") || end.equals("mpeg")|| end.equals("mp4"))
     {
     type = "audio";
     }
     else if (end.equals("jpg") || end.equals("gif")|| end.equals("png") || end.equals("jpeg"))
     {
     type = "image";
     }
     else
     {
     type = "*";
     }
     type += "/*";
     return type;
     }
     ---------------------------------------------------------------
     ---------------------------------------------------------------
     ---------------------------------------------------------------
     现在开发中的功能需要直接跳转到拨号、联系人、短信界面等等，查找了很多资料，自己整理了一下。
     1、跳转到拨号界面，代码如下：
     1）直接拨打
     Intent intentPhone = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
     startActivity(intentPhone);
     2）跳转到拨号界面
     Intent intent = newIntent(Intent.ACTION_DIAL,Uri.parse("tel:" + phoneNumber));
     intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
     startActivity(intent);
     2、跳转到联系人页面，使用一下代码：
     Intent intentPhone = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
     startActivity(intentPhone);
     ---------------------------------------------------------------
     3---------------------------------------------------------------
     ---------------------------------------------------------------
     *
     *
     */
}
