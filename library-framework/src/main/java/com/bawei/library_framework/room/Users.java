package com.bawei.library_framework.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

public
/**
 *作者：王先生
 *时间：2021/12/22 19:03
 *用途：
 */
@Entity
class Users implements Serializable {
    @PrimaryKey
    private Long createTime;
    private String names;
    private String pics;
    private String prices;
    private int state;
    private float ratingBar;
    private String text;


    public Users(Long createTime, String names, String pics, String prices, int state, float ratingBar, String text) {
        this.createTime = createTime;
        this.names = names;
        this.pics = pics;
        this.prices = prices;
        this.state = state;
        this.ratingBar = ratingBar;
        this.text = text;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public float getRatingBar() {
        return ratingBar;
    }

    public void setRatingBar(float ratingBar) {
        this.ratingBar = ratingBar;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

