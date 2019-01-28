package com.bdqn.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Engage {

    private Integer id;//编号
    private String name;//客户名
    private String phone;//客户电话
    private Date engageTime;//预订时间
    private Date arriveTime;//预抵时间
    private Integer mark;//预订状态
    private String remark;//备注
    private String roomId;//客房对象

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getEngageTime() {
        return engageTime;
    }

    public void setEngageTime(Date engageTime) {
        this.engageTime = engageTime;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Engage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", engageTime=" + engageTime +
                ", arriveTime=" + arriveTime +
                ", mark=" + mark +
                ", remark='" + remark + '\'' +
                '}';
    }
}
