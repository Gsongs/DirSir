package com.bawei.library_framework.sp;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

public
/**
 *作者：王先生
 *时间：2021/12/11 09:30
 *用途：
 */
class Preferences {
    private static Preferences singleton = null;
    /**
     * 文件名
     */
    private String FILL_NAME = "Preferences";
    /**
     * 共享对象参数
     */
    private SharedPreferences sp;

    /**
     * 构造私有化
     */
    private Preferences() { }

    public static Preferences getInstance() {
        if (null == singleton) {
            synchronized (Preferences.class) {
                if (null == singleton) {
                    singleton = new Preferences();
                }
            }
        }
        return singleton;
    }

    /**
     * 初始化
     * @param context 上下文
     */
    public void init(Context context){
        sp = context.getSharedPreferences(FILL_NAME, Context.MODE_PRIVATE);
    }

    /**
     * 保存数据
     *
     * @param key   键值
     * @param value 数据
     */
    public void put(String key, Object value) {
        SharedPreferences.Editor edit = sp.edit();
        if (value instanceof String) {
            edit.putString(key, (String) value);
        } else if (value instanceof Integer) {
            edit.putInt(key, (Integer) value);
        } else if (value instanceof Boolean) {
            edit.putBoolean(key, (Boolean) value);
        } else if (value instanceof Long) {
            edit.putLong(key, (Long) value);
        } else if (value instanceof Float) {
            edit.putFloat(key, (Float) value);
        }
        edit.commit();
    }

    /**
     * 获取数据
     * @param key 键值
     * @param defaultValue 默认值
     * @return 数据
     */
    public Object get(@NonNull String key, @NonNull Object defaultValue) {
        if (defaultValue instanceof String) {
            return sp.getString(key, (String) defaultValue);
        } else if (defaultValue instanceof Integer) {
            return sp.getInt(key, (Integer) defaultValue);
        } else if (defaultValue instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultValue);
        } else if (defaultValue instanceof Long) {
            return sp.getLong(key, (Long) defaultValue);
        } else if (defaultValue instanceof Float) {
            return sp.getFloat(key, (Float) defaultValue);
        }
        return null;
    }

}
