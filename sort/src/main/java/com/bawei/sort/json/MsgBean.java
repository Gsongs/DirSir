package com.bawei.sort.json;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public
/**
 *作者：王先生
 *时间：2021/12/20 08:42
 *用途：
 */
class MsgBean implements MultiItemEntity {

    private int id;
    private int userid;
    private int provinceid;
    private int cityid;
    private int areaid;
    private String address;
    private String phonenum;
    private String isdefault;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private int index;


    public MsgBean(int id, int userid, int provinceid, int cityid, int areaid, String address, String phonenum, String isdefault) {
        this.id = id;
        this.userid = userid;
        this.provinceid = provinceid;
        this.cityid = cityid;
        this.areaid = areaid;
        this.address = address;
        this.phonenum = phonenum;
        this.isdefault = isdefault;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(int provinceid) {
        this.provinceid = provinceid;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public int getAreaid() {
        return areaid;
    }

    public void setAreaid(int areaid) {
        this.areaid = areaid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(String isdefault) {
        this.isdefault = isdefault;
    }

    @Override
    public int getItemType() {
        return index;
    }
}
