package com.bawei.library_framework.data.user;

import android.os.Parcel;
import android.os.Parcelable;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

@Entity
/**
 *作者：王先生
 *时间：2021/12/10 17:36
 *用途：UserDao实体类
 */
public class User implements Serializable{
    private static final long serialVersionUID = 1020316326623200411L;
    @Id(autoincrement = true)
    private Long User_id;
    private String name;
    private String pic;
    private int  price;
    private int num;
    private Boolean chbox;
    @Generated(hash = 310269507)
    public User(Long User_id, String name, String pic, int price, int num,
            Boolean chbox) {
        this.User_id = User_id;
        this.name = name;
        this.pic = pic;
        this.price = price;
        this.num = num;
        this.chbox = chbox;
    }
    @Generated(hash = 586692638)
    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "User_id=" + User_id +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", chbox=" + chbox +
                '}';
    }

    public Long getUser_id() {
        return this.User_id;
    }
    public void setUser_id(Long User_id) {
        this.User_id = User_id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPic() {
        return this.pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getNum() {
        return this.num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public Boolean getChbox() {
        return this.chbox;
    }
    public void setChbox(Boolean chbox) {
        this.chbox = chbox;
    }
}
