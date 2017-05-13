package test.bwie.com.date20170512.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/13
 */
public class DataBean implements Parcelable {
    /**
     * id : 121
     * goods_name : 镇店之宝丨美白嫩肤面膜7片
     * shop_price : 49.9
     * market_price : 99.0
     * is_coupon_allowed : true
     * is_allow_credit : false
     * goods_img : https://image.yunifang.com/yunifang/images/goods/121/goods_img/170301091610311632161123479.jpg
     * sales_volume : 123126
     * efficacy : 镇店之宝 美白爆款
     * sort : 0
     */

    private String id;
    private String goods_name;
    private double shop_price;
    private double market_price;
    private boolean is_coupon_allowed;
    private boolean is_allow_credit;
    private String goods_img;
    private int sales_volume;
    private String efficacy;
    private int sort;
    private boolean check;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public double getShop_price() {
        return shop_price;
    }

    public void setShop_price(double shop_price) {
        this.shop_price = shop_price;
    }

    public double getMarket_price() {
        return market_price;
    }

    public void setMarket_price(double market_price) {
        this.market_price = market_price;
    }

    public boolean isIs_coupon_allowed() {
        return is_coupon_allowed;
    }

    public void setIs_coupon_allowed(boolean is_coupon_allowed) {
        this.is_coupon_allowed = is_coupon_allowed;
    }

    public boolean isIs_allow_credit() {
        return is_allow_credit;
    }

    public void setIs_allow_credit(boolean is_allow_credit) {
        this.is_allow_credit = is_allow_credit;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }

    public int getSales_volume() {
        return sales_volume;
    }

    public void setSales_volume(int sales_volume) {
        this.sales_volume = sales_volume;
    }

    public String getEfficacy() {
        return efficacy;
    }

    public void setEfficacy(String efficacy) {
        this.efficacy = efficacy;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.goods_name);
        dest.writeDouble(this.shop_price);
        dest.writeDouble(this.market_price);
        dest.writeByte(this.is_coupon_allowed ? (byte) 1 : (byte) 0);
        dest.writeByte(this.is_allow_credit ? (byte) 1 : (byte) 0);
        dest.writeString(this.goods_img);
        dest.writeInt(this.sales_volume);
        dest.writeString(this.efficacy);
        dest.writeInt(this.sort);
        dest.writeByte(this.check ? (byte) 1 : (byte) 0);
    }

    public DataBean() {
    }

    protected DataBean(Parcel in) {
        this.id = in.readString();
        this.goods_name = in.readString();
        this.shop_price = in.readDouble();
        this.market_price = in.readDouble();
        this.is_coupon_allowed = in.readByte() != 0;
        this.is_allow_credit = in.readByte() != 0;
        this.goods_img = in.readString();
        this.sales_volume = in.readInt();
        this.efficacy = in.readString();
        this.sort = in.readInt();
        this.check = in.readByte() != 0;
    }

    public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
        @Override
        public DataBean createFromParcel(Parcel source) {
            return new DataBean(source);
        }

        @Override
        public DataBean[] newArray(int size) {
            return new DataBean[size];
        }
    };
}
