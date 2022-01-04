package com.bawei.home.jomejson.json;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public
/**
 *作者：王先生
 *时间：2021/12/13 11:14
 *用途：
 */
class FoodBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean implements MultiItemEntity {
        @SerializedName("CategoryId")
        private int categoryId;
        @SerializedName("CategoryName")
        private String categoryName;
        @SerializedName("CommissionRate")
        private String commissionRate;
        @SerializedName("CommissionType")
        private String commissionType;
        @SerializedName("CouponAmount")
        private Object couponAmount;
        @SerializedName("CouponEndTime")
        private Object couponEndTime;
        @SerializedName("CouponId")
        private String couponId;
        @SerializedName("CouponInfo")
        private String couponInfo;
        @SerializedName("CouponRemainCount")
        private int couponRemainCount;
        @SerializedName("CouponShareUrl")
        private Object couponShareUrl;
        @SerializedName("CouponStartFee")
        private Object couponStartFee;
        @SerializedName("CouponStartTime")
        private Object couponStartTime;
        @SerializedName("CouponTotalCount")
        private int couponTotalCount;
        @SerializedName("Distance")
        private Object distance;
        @SerializedName("IncludeDxjh")
        private String includeDxjh;
        @SerializedName("IncludeMkt")
        private String includeMkt;
        @SerializedName("InfoDxjh")
        private String infoDxjh;
        @SerializedName("ItemDescription")
        private String itemDescription;
        @SerializedName("ItemId")
        private long itemId;
        @SerializedName("ItemUrl")
        private String itemUrl;
        @SerializedName("JddNum")
        private int jddNum;
        @SerializedName("JddPrice")
        private Object jddPrice;
        @SerializedName("KuadianPromotionInfo")
        private Object kuadianPromotionInfo;
        @SerializedName("LevelOneCategoryId")
        private int levelOneCategoryId;
        @SerializedName("LevelOneCategoryName")
        private String levelOneCategoryName;
        @SerializedName("LockRate")
        private Object lockRate;
        @SerializedName("LockRateEndTime")
        private int lockRateEndTime;
        @SerializedName("LockRateStartTime")
        private int lockRateStartTime;
        @SerializedName("Nick")
        private String nick;
        @SerializedName("NumIid")
        private long numIid;
        @SerializedName("Oetime")
        private Object oetime;
        @SerializedName("OrigPrice")
        private Object origPrice;
        @SerializedName("Ostime")
        private Object ostime;
        @SerializedName("PictUrl")
        private String pictUrl;
        @SerializedName("PresaleDeposit")
        private String presaleDeposit;
        @SerializedName("PresaleDiscountFeeText")
        private Object presaleDiscountFeeText;
        @SerializedName("PresaleEndTime")
        private int presaleEndTime;
        @SerializedName("PresaleStartTime")
        private int presaleStartTime;
        @SerializedName("PresaleTailEndTime")
        private int presaleTailEndTime;
        @SerializedName("PresaleTailStartTime")
        private int presaleTailStartTime;
        @SerializedName("Provcity")
        private String provcity;
        @SerializedName("RealPostFee")
        private String realPostFee;
        @SerializedName("ReservePrice")
        private String reservePrice;
        @SerializedName("SaleBeginTime")
        private Object saleBeginTime;
        @SerializedName("SaleEndTime")
        private Object saleEndTime;
        @SerializedName("SalePrice")
        private Object salePrice;
        @SerializedName("SellNum")
        private int sellNum;
        @SerializedName("SellerId")
        private long sellerId;
        @SerializedName("ShopDsr")
        private int shopDsr;
        @SerializedName("ShopTitle")
        private String shopTitle;
        @SerializedName("ShortTitle")
        private String shortTitle;
        @SerializedName("SmallImages")
        private List<String> smallImages;
        @SerializedName("Stock")
        private int stock;
        @SerializedName("Title")
        private String title;
        @SerializedName("TkTotalCommi")
        private String tkTotalCommi;
        @SerializedName("TkTotalSales")
        private String tkTotalSales;
        @SerializedName("TmallPlayActivityInfo")
        private Object tmallPlayActivityInfo;
        @SerializedName("TotalStock")
        private int totalStock;
        @SerializedName("Url")
        private String url;
        @SerializedName("UsableShopId")
        private Object usableShopId;
        @SerializedName("UsableShopName")
        private Object usableShopName;
        @SerializedName("UserType")
        private int userType;
        @SerializedName("UvSumPreSale")
        private int uvSumPreSale;
        @SerializedName("Volume")
        private int volume;
        @SerializedName("WhiteImage")
        private String whiteImage;
        @SerializedName("XId")
        private String xId;
        @SerializedName("YsylClickUrl")
        private Object ysylClickUrl;
        @SerializedName("YsylCommissionRate")
        private Object ysylCommissionRate;
        @SerializedName("YsylTljFace")
        private Object ysylTljFace;
        @SerializedName("YsylTljSendTime")
        private Object ysylTljSendTime;
        @SerializedName("YsylTljUseEndTime")
        private Object ysylTljUseEndTime;
        @SerializedName("YsylTljUseStartTime")
        private Object ysylTljUseStartTime;
        @SerializedName("ZkFinalPrice")
        private String zkFinalPrice;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @SerializedName("Index")
        private int index;


        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCommissionRate() {
            return commissionRate;
        }

        public void setCommissionRate(String commissionRate) {
            this.commissionRate = commissionRate;
        }

        public String getCommissionType() {
            return commissionType;
        }

        public void setCommissionType(String commissionType) {
            this.commissionType = commissionType;
        }

        public Object getCouponAmount() {
            return couponAmount;
        }

        public void setCouponAmount(Object couponAmount) {
            this.couponAmount = couponAmount;
        }

        public Object getCouponEndTime() {
            return couponEndTime;
        }

        public void setCouponEndTime(Object couponEndTime) {
            this.couponEndTime = couponEndTime;
        }

        public String getCouponId() {
            return couponId;
        }

        public void setCouponId(String couponId) {
            this.couponId = couponId;
        }

        public String getCouponInfo() {
            return couponInfo;
        }

        public void setCouponInfo(String couponInfo) {
            this.couponInfo = couponInfo;
        }

        public int getCouponRemainCount() {
            return couponRemainCount;
        }

        public void setCouponRemainCount(int couponRemainCount) {
            this.couponRemainCount = couponRemainCount;
        }

        public Object getCouponShareUrl() {
            return couponShareUrl;
        }

        public void setCouponShareUrl(Object couponShareUrl) {
            this.couponShareUrl = couponShareUrl;
        }

        public Object getCouponStartFee() {
            return couponStartFee;
        }

        public void setCouponStartFee(Object couponStartFee) {
            this.couponStartFee = couponStartFee;
        }

        public Object getCouponStartTime() {
            return couponStartTime;
        }

        public void setCouponStartTime(Object couponStartTime) {
            this.couponStartTime = couponStartTime;
        }

        public int getCouponTotalCount() {
            return couponTotalCount;
        }

        public void setCouponTotalCount(int couponTotalCount) {
            this.couponTotalCount = couponTotalCount;
        }

        public Object getDistance() {
            return distance;
        }

        public void setDistance(Object distance) {
            this.distance = distance;
        }

        public String getIncludeDxjh() {
            return includeDxjh;
        }

        public void setIncludeDxjh(String includeDxjh) {
            this.includeDxjh = includeDxjh;
        }

        public String getIncludeMkt() {
            return includeMkt;
        }

        public void setIncludeMkt(String includeMkt) {
            this.includeMkt = includeMkt;
        }

        public String getInfoDxjh() {
            return infoDxjh;
        }

        public void setInfoDxjh(String infoDxjh) {
            this.infoDxjh = infoDxjh;
        }

        public String getItemDescription() {
            return itemDescription;
        }

        public void setItemDescription(String itemDescription) {
            this.itemDescription = itemDescription;
        }

        public long getItemId() {
            return itemId;
        }

        public void setItemId(long itemId) {
            this.itemId = itemId;
        }

        public String getItemUrl() {
            return itemUrl;
        }

        public void setItemUrl(String itemUrl) {
            this.itemUrl = itemUrl;
        }

        public int getJddNum() {
            return jddNum;
        }

        public void setJddNum(int jddNum) {
            this.jddNum = jddNum;
        }

        public Object getJddPrice() {
            return jddPrice;
        }

        public void setJddPrice(Object jddPrice) {
            this.jddPrice = jddPrice;
        }

        public Object getKuadianPromotionInfo() {
            return kuadianPromotionInfo;
        }

        public void setKuadianPromotionInfo(Object kuadianPromotionInfo) {
            this.kuadianPromotionInfo = kuadianPromotionInfo;
        }

        public int getLevelOneCategoryId() {
            return levelOneCategoryId;
        }

        public void setLevelOneCategoryId(int levelOneCategoryId) {
            this.levelOneCategoryId = levelOneCategoryId;
        }

        public String getLevelOneCategoryName() {
            return levelOneCategoryName;
        }

        public void setLevelOneCategoryName(String levelOneCategoryName) {
            this.levelOneCategoryName = levelOneCategoryName;
        }

        public Object getLockRate() {
            return lockRate;
        }

        public void setLockRate(Object lockRate) {
            this.lockRate = lockRate;
        }

        public int getLockRateEndTime() {
            return lockRateEndTime;
        }

        public void setLockRateEndTime(int lockRateEndTime) {
            this.lockRateEndTime = lockRateEndTime;
        }

        public int getLockRateStartTime() {
            return lockRateStartTime;
        }

        public void setLockRateStartTime(int lockRateStartTime) {
            this.lockRateStartTime = lockRateStartTime;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public long getNumIid() {
            return numIid;
        }

        public void setNumIid(long numIid) {
            this.numIid = numIid;
        }

        public Object getOetime() {
            return oetime;
        }

        public void setOetime(Object oetime) {
            this.oetime = oetime;
        }

        public Object getOrigPrice() {
            return origPrice;
        }

        public void setOrigPrice(Object origPrice) {
            this.origPrice = origPrice;
        }

        public Object getOstime() {
            return ostime;
        }

        public void setOstime(Object ostime) {
            this.ostime = ostime;
        }

        public String getPictUrl() {
            return pictUrl;
        }

        public void setPictUrl(String pictUrl) {
            this.pictUrl = pictUrl;
        }

        public String getPresaleDeposit() {
            return presaleDeposit;
        }

        public void setPresaleDeposit(String presaleDeposit) {
            this.presaleDeposit = presaleDeposit;
        }

        public Object getPresaleDiscountFeeText() {
            return presaleDiscountFeeText;
        }

        public void setPresaleDiscountFeeText(Object presaleDiscountFeeText) {
            this.presaleDiscountFeeText = presaleDiscountFeeText;
        }

        public int getPresaleEndTime() {
            return presaleEndTime;
        }

        public void setPresaleEndTime(int presaleEndTime) {
            this.presaleEndTime = presaleEndTime;
        }

        public int getPresaleStartTime() {
            return presaleStartTime;
        }

        public void setPresaleStartTime(int presaleStartTime) {
            this.presaleStartTime = presaleStartTime;
        }

        public int getPresaleTailEndTime() {
            return presaleTailEndTime;
        }

        public void setPresaleTailEndTime(int presaleTailEndTime) {
            this.presaleTailEndTime = presaleTailEndTime;
        }

        public int getPresaleTailStartTime() {
            return presaleTailStartTime;
        }

        public void setPresaleTailStartTime(int presaleTailStartTime) {
            this.presaleTailStartTime = presaleTailStartTime;
        }

        public String getProvcity() {
            return provcity;
        }

        public void setProvcity(String provcity) {
            this.provcity = provcity;
        }

        public String getRealPostFee() {
            return realPostFee;
        }

        public void setRealPostFee(String realPostFee) {
            this.realPostFee = realPostFee;
        }

        public String getReservePrice() {
            return reservePrice;
        }

        public void setReservePrice(String reservePrice) {
            this.reservePrice = reservePrice;
        }

        public Object getSaleBeginTime() {
            return saleBeginTime;
        }

        public void setSaleBeginTime(Object saleBeginTime) {
            this.saleBeginTime = saleBeginTime;
        }

        public Object getSaleEndTime() {
            return saleEndTime;
        }

        public void setSaleEndTime(Object saleEndTime) {
            this.saleEndTime = saleEndTime;
        }

        public Object getSalePrice() {
            return salePrice;
        }

        public void setSalePrice(Object salePrice) {
            this.salePrice = salePrice;
        }

        public int getSellNum() {
            return sellNum;
        }

        public void setSellNum(int sellNum) {
            this.sellNum = sellNum;
        }

        public long getSellerId() {
            return sellerId;
        }

        public void setSellerId(long sellerId) {
            this.sellerId = sellerId;
        }

        public int getShopDsr() {
            return shopDsr;
        }

        public void setShopDsr(int shopDsr) {
            this.shopDsr = shopDsr;
        }

        public String getShopTitle() {
            return shopTitle;
        }

        public void setShopTitle(String shopTitle) {
            this.shopTitle = shopTitle;
        }

        public String getShortTitle() {
            return shortTitle;
        }

        public void setShortTitle(String shortTitle) {
            this.shortTitle = shortTitle;
        }

        public List<String> getSmallImages() {
            return smallImages;
        }

        public void setSmallImages(List<String> smallImages) {
            this.smallImages = smallImages;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTkTotalCommi() {
            return tkTotalCommi;
        }

        public void setTkTotalCommi(String tkTotalCommi) {
            this.tkTotalCommi = tkTotalCommi;
        }

        public String getTkTotalSales() {
            return tkTotalSales;
        }

        public void setTkTotalSales(String tkTotalSales) {
            this.tkTotalSales = tkTotalSales;
        }

        public Object getTmallPlayActivityInfo() {
            return tmallPlayActivityInfo;
        }

        public void setTmallPlayActivityInfo(Object tmallPlayActivityInfo) {
            this.tmallPlayActivityInfo = tmallPlayActivityInfo;
        }

        public int getTotalStock() {
            return totalStock;
        }

        public void setTotalStock(int totalStock) {
            this.totalStock = totalStock;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Object getUsableShopId() {
            return usableShopId;
        }

        public void setUsableShopId(Object usableShopId) {
            this.usableShopId = usableShopId;
        }

        public Object getUsableShopName() {
            return usableShopName;
        }

        public void setUsableShopName(Object usableShopName) {
            this.usableShopName = usableShopName;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getUvSumPreSale() {
            return uvSumPreSale;
        }

        public void setUvSumPreSale(int uvSumPreSale) {
            this.uvSumPreSale = uvSumPreSale;
        }

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        public String getWhiteImage() {
            return whiteImage;
        }

        public void setWhiteImage(String whiteImage) {
            this.whiteImage = whiteImage;
        }

        public String getXId() {
            return xId;
        }

        public void setXId(String xId) {
            this.xId = xId;
        }

        public Object getYsylClickUrl() {
            return ysylClickUrl;
        }

        public void setYsylClickUrl(Object ysylClickUrl) {
            this.ysylClickUrl = ysylClickUrl;
        }

        public Object getYsylCommissionRate() {
            return ysylCommissionRate;
        }

        public void setYsylCommissionRate(Object ysylCommissionRate) {
            this.ysylCommissionRate = ysylCommissionRate;
        }

        public Object getYsylTljFace() {
            return ysylTljFace;
        }

        public void setYsylTljFace(Object ysylTljFace) {
            this.ysylTljFace = ysylTljFace;
        }

        public Object getYsylTljSendTime() {
            return ysylTljSendTime;
        }

        public void setYsylTljSendTime(Object ysylTljSendTime) {
            this.ysylTljSendTime = ysylTljSendTime;
        }

        public Object getYsylTljUseEndTime() {
            return ysylTljUseEndTime;
        }

        public void setYsylTljUseEndTime(Object ysylTljUseEndTime) {
            this.ysylTljUseEndTime = ysylTljUseEndTime;
        }

        public Object getYsylTljUseStartTime() {
            return ysylTljUseStartTime;
        }

        public void setYsylTljUseStartTime(Object ysylTljUseStartTime) {
            this.ysylTljUseStartTime = ysylTljUseStartTime;
        }

        public String getZkFinalPrice() {
            return zkFinalPrice;
        }

        public void setZkFinalPrice(String zkFinalPrice) {
            this.zkFinalPrice = zkFinalPrice;
        }

        @Override
        public int getItemType() {
            return index;
        }
    }
}
