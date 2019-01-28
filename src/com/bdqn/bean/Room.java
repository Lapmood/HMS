package com.bdqn.bean;

public class Room {

    private Integer id;//主键编号
    private String roomId;//客房号
    private String roomType;//客户类型
    private String state;//客房状态
    private String location;//客房地址
    private String tele;//客户电话
    private String remark;//备注
    private Integer bed;//床位数
    private Double price;//价格
    private Integer hourRoom;//钟点房
    private Double hourPrice;//钟点房价格

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getBed() {
        return bed;
    }

    public void setBed(Integer bed) {
        this.bed = bed;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getHourRoom() {
        return hourRoom;
    }

    public void setHourRoom(Integer hourRoom) {
        this.hourRoom = hourRoom;
    }

    public Double getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(Double hourPrice) {
        this.hourPrice = hourPrice;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomId='" + roomId + '\'' +
                ", roomType='" + roomType + '\'' +
                ", state='" + state + '\'' +
                ", location='" + location + '\'' +
                ", tele='" + tele + '\'' +
                ", remark='" + remark + '\'' +
                ", bed=" + bed +
                ", price=" + price +
                ", hourRoom=" + hourRoom +
                ", hourPrice=" + hourPrice +
                '}';
    }
}
