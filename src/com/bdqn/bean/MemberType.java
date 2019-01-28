package com.bdqn.bean;

public class MemberType {

    private Integer id; //主键,编号
    private String type;//会员类型
    private Double discount;//会员折扣
    private String remark;//备注

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "MemberType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", discount=" + discount +
                ", remark='" + remark + '\'' +
                '}';
    }
}
