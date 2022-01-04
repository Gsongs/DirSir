package com.bawei.library_framework.room;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public
/**
 *作者：王先生
 *时间：2021/12/22 19:04
 *用途：
 */
interface UserRoom {
    @Insert
    void insert(Users... users);

    @Insert
    void insert(Users users);

    @Insert
    void insert(List<Users> userLists);

    @Delete
    void delete(Users users);

    @Query("SELECT * FROM users")
    List<Users> getAllUsers();

    @Update
    void updata(Users users);




}
