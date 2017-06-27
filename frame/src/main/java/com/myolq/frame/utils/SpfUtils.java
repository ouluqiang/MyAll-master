package com.myolq.frame.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * SharedPreferences工具类
 * 
 * @author
 *
 */
public class SpfUtils {

	private SharedPreferences mShared;
	private Editor mEditor;

	public SpfUtils(Context context, final String file_name) {

		mShared = context.getSharedPreferences(file_name, Context.MODE_PRIVATE);
		mEditor = mShared.edit();
	}

	/**
	 * 添加保存数据(需调用commit()方法提交)
	 * 
	 * @param key
	 * @param object
	 */
	public void put(String key, Object object) {
		if (object instanceof String) {
			mEditor.putString(key, (String) object);
		} else if (object instanceof Integer) {
			mEditor.putInt(key, (Integer) object);
		} else if (object instanceof Boolean) {
			mEditor.putBoolean(key, (Boolean) object);
		} else if (object instanceof Float) {
			mEditor.putFloat(key, (Float) object);
		} else if (object instanceof Long) {
			mEditor.putLong(key, (Long) object);
		} else {
			mEditor.putString(key, object.toString());
		}
	}

	/**
	 * 提交
	 */
	public void commit() {
		SharedPreferencesCompat.apply(mEditor);
	}

	/**
	 * 保存数据
	 * 
	 * @param key
	 * @param object
	 */
	public void save(String key, Object object) {
		put(key, object);
		commit();
	}

	/**
	 * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
	 * 
	 * @param context
	 * @param key
	 * @param defaultObject
	 * @return
	 */
	public Object get(String key, Object defaultObject) {

		if (defaultObject instanceof String) {
			return mShared.getString(key, (String) defaultObject);
		} else if (defaultObject instanceof Integer) {
			return mShared.getInt(key, (Integer) defaultObject);
		} else if (defaultObject instanceof Boolean) {
			return mShared.getBoolean(key, (Boolean) defaultObject);
		} else if (defaultObject instanceof Float) {
			return mShared.getFloat(key, (Float) defaultObject);
		} else if (defaultObject instanceof Long) {
			return mShared.getLong(key, (Long) defaultObject);
		}

		return null;
	}

	/**
	 * 移除某个key值已经对应的值
	 * 
	 * @param key
	 */
	public void remove(String key) {
		mEditor.remove(key);
		commit();
	}

	/**
	 * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
	 * 
	 * @param context
	 * @param file_name
	 * @param key
	 * @param object
	 */
	public static void save(Context context, String file_name, String key, Object object) {

		SharedPreferences sp = context.getSharedPreferences(file_name, Context.MODE_PRIVATE);
		Editor editor = sp.edit();

		if (object instanceof String) {
			editor.putString(key, (String) object);
		} else if (object instanceof Integer) {
			editor.putInt(key, (Integer) object);
		} else if (object instanceof Boolean) {
			editor.putBoolean(key, (Boolean) object);
		} else if (object instanceof Float) {
			editor.putFloat(key, (Float) object);
		} else if (object instanceof Long) {
			editor.putLong(key, (Long) object);
		} else {
			editor.putString(key, object.toString());
		}

		SharedPreferencesCompat.apply(editor);
	}

	/**
	 * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
	 * 
	 * @param context
	 * @param key
	 * @param defaultObject
	 * @return
	 */
	public static Object get(Context context, String file_name, String key, Object defaultObject) {
		SharedPreferences sp = context.getSharedPreferences(file_name, Context.MODE_PRIVATE);

		if (defaultObject instanceof String) {
			return sp.getString(key, (String) defaultObject);
		} else if (defaultObject instanceof Integer) {
			return sp.getInt(key, (Integer) defaultObject);
		} else if (defaultObject instanceof Boolean) {
			return sp.getBoolean(key, (Boolean) defaultObject);
		} else if (defaultObject instanceof Float) {
			return sp.getFloat(key, (Float) defaultObject);
		} else if (defaultObject instanceof Long) {
			return sp.getLong(key, (Long) defaultObject);
		}

		return null;
	}

	/**
	 * 针对复杂类型存储<对象>
	 * 
	 * @param context
	 * @param file_name
	 * @param key
	 * @param object
	 */
	public static void saveObject(Context context, String file_name, String key, Object object) {
		SharedPreferences sp = context.getSharedPreferences(file_name, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = null;
		try {

			out = new ObjectOutputStream(baos);
			out.writeObject(object);
			String objectVal = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
			if (!TextUtils.isEmpty(objectVal)) {
				editor.putString(key, objectVal);
				SharedPreferencesCompat.apply(editor);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (baos != null) {
					baos.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取复杂类型存储<对象>
	 * 
	 * @param context
	 * @param file_name
	 * @param key
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getObject(Context context, String file_name, String key, Class<T> clazz) {
		SharedPreferences sp = context.getSharedPreferences(file_name, Context.MODE_PRIVATE);
		if (sp.contains(key)) {
			String objectVal = sp.getString(key, null);
			if (TextUtils.isEmpty(objectVal)) {
				return null;
			}
			byte[] buffer = Base64.decode(objectVal, Base64.DEFAULT);
			ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(bais);
				T t = (T) ois.readObject();
				return t;
			} catch (StreamCorruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					if (bais != null) {
						bais.close();
					}
					if (ois != null) {
						ois.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * 移除某个key值已经对应的值
	 * 
	 * @param context
	 * @param file_name
	 * @param key
	 */
	public static void remove(Context context, String file_name, String key) {
		SharedPreferences sp = context.getSharedPreferences(file_name, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.remove(key);
		SharedPreferencesCompat.apply(editor);
	}

	/**
	 * 清除所有数据
	 * 
	 * @param context
	 * @param file_name
	 */
	public static void clear(Context context, String file_name) {
		SharedPreferences sp = context.getSharedPreferences(file_name, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.clear();
		SharedPreferencesCompat.apply(editor);
	}

	/**
	 * 查询某个key是否已经存在
	 * 
	 * @param context
	 * @param file_name
	 * @param key
	 * @return
	 */
	public static boolean contains(Context context, String file_name, String key) {
		SharedPreferences sp = context.getSharedPreferences(file_name, Context.MODE_PRIVATE);
		return sp.contains(key);
	}

	/**
	 * 返回所有的键值对
	 * 
	 * @param context
	 * @param file_name
	 * @return
	 */
	public static Map<String, ?> getAll(Context context, String file_name) {
		SharedPreferences sp = context.getSharedPreferences(file_name, Context.MODE_PRIVATE);
		return sp.getAll();
	}

	/**
	 * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
	 * 
	 * @author
	 * 
	 */
	private static class SharedPreferencesCompat {
		private static final Method sApplyMethod = findApplyMethod();

		/**
		 * 反射查找apply的方法
		 * 
		 * @return
		 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		private static Method findApplyMethod() {
			try {
				Class clz = Editor.class;
				return clz.getMethod("apply");
			} catch (NoSuchMethodException e) {
			}

			return null;
		}

		/**
		 * 如果找到则使用apply执行，否则使用commit
		 * 
		 * @param editor
		 */
		public static void apply(Editor editor) {
			try {
				if (sApplyMethod != null) {
					sApplyMethod.invoke(editor);
					return;
				}
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {
			} catch (InvocationTargetException e) {
			}
			editor.commit();
		}
	}
}
