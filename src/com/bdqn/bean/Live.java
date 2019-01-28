package com.bdqn.bean;

import java.util.Date;

public class Live {
    //id,room_id roomId,in_no inNo,customer_name customerName,sex,zj_type zjType,zj_no zjNo,number,in_time inTime,days,foregift foreGift,reality_days realityDays,chk_time chkTime,money,remark

    private Integer id;//主键
    private Integer roomId;//客房编号
    private String inNo;//入住单号
    private String customerName;//客户姓名
    private String sex;//客户性别
    private String zjType;//证件类型
    private String zjNo;//证件编号
    private Integer number;//人数
    private Date inTime;//入住时间
    private Integer days;//预住天数
    private Double foreGift;//押金
    private String remark;//备注
    private Integer realityDays;//实住天数
    private Date chkTime;//结算时间
    private Double money;//结算金额

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getInNo() {
        return inNo;
    }

    public void setInNo(String inNo) {
        this.inNo = inNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getZjType() {
        return zjType;
    }

    public void setZjType(String zjType) {
        this.zjType = zjType;
    }

    public String getZjNo() {
        return zjNo;
    }

    public void setZjNo(String zjNo) {
        this.zjNo = zjNo;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getForeGift() {
        return foreGift;
    }

    public void setForeGift(Double foreGift) {
        this.foreGift = foreGift;
    }

    public Integer getRealityDays() {
        return realityDays;
    }

    public void setRealityDays(Integer realityDays) {
        this.realityDays = realityDays;
    }

    public Date getChkTime() {
        return chkTime;
    }

    public void setChkTime(Date chkTime) {
        this.chkTime = chkTime;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Live{" +
                "id=" + id +
                ", roomId=" + roomId +
                ", inNo='" + inNo + '\'' +
                ", customerName='" + customerName + '\'' +
                ", sex='" + sex + '\'' +
                ", zjType='" + zjType + '\'' +
                ", zjNo='" + zjNo + '\'' +
                ", number=" + number +
                ", inTime=" + inTime +
                ", days=" + days +
                ", foreGift=" + foreGift +
                ", realityDays=" + realityDays +
                ", chkTime=" + chkTime +
                ", money=" + money +
                ", remark='" + remark + '\'' +
                '}';
    }
}
