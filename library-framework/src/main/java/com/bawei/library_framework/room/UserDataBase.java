package com.bawei.library_framework.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.bawei.library_framework.data.db.UserDao;

public abstract
/**
 *作者：王先生
 *时间：2021/12/22 19:06
 *用途：
 */
@Database(entities = { Users.class }, version = 1,exportSchema = false)
class  UserDataBase extends RoomDatabase {
    private static final String DB_NAME = "UserDatabase.db";
    private static volatile UserDataBase instance;

    public static synchronized UserDataBase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static UserDataBase create(final Context context) {
        return Room.databaseBuilder(
                context,
                UserDataBase.class,
                DB_NAME).allowMainThreadQueries().build();
    }

    public abstract UserRoom getUserRoom();

}

