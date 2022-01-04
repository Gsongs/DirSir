package com.bawei.library_framework.database;

import android.database.sqlite.SQLiteDatabase;

import com.bawei.library_framework.data.db.DaoMaster;
import com.bawei.library_framework.data.db.DaoSession;
import com.bawei.library_framework.data.db.UserDao;
import com.blankj.utilcode.util.Utils;

public
/**
 *作者：王先生
 *时间：2021/12/14 18:55
 *用途：目前为止性能最高、内存消耗最小
 * 使用人数众多，开发者长期维护。
 * 使用简单：简洁直观的API
 * 跨实体查询，甚至链接复杂关系代码自动生成开源支持缓存
 */
class UserManager {

    //实现双重锁保证可见性。使用 volatile定义的变量，将会保证对所有线程的可见性。禁止指令重排序优化。
    //由于 volatile禁止对象创建时指令之间重排序，所以其他线程不会访问到一个未初始化的对象，从而保证安全性。
    public static UserManager manager;
    private UserDao userDao;
    public static UserManager getInstance(){
        if (manager==null){
            synchronized (UserManager.class){
                manager = new UserManager();
            }
        }
        return manager;
    }

    public UserManager(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(Utils.getApp(),"name.db");
        SQLiteDatabase db = helper.getWritableDatabase();

        DaoMaster master = new DaoMaster(db);
        DaoSession session = master.newSession();
        userDao = session.getUserDao();
    }
    //外部调用这个方法
    public UserDao getUsersDao(){
        return userDao;
    }
}
