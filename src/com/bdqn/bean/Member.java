package com.bdqn.bean;

public class Member {

    private Integer id;//主键编号
    private String memberId;//会员编号
    private String memberName;//会员姓名
    private Integer memberType;//会员类型
    private String sex;//会员性别
    private String idCard;//会员身份证号
    private String status;//会员状态
    private String address;//会员地址
    private String phone;//会员手机号
    private Double balance;//余额
    private Double totalMoney;//总消费
    private String remark;//备注

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", memberId='" + memberId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberType=" + memberType +
                ", sex='" + sex + '\'' +
                ", idCard='" + idCard + '\'' +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                ", totalMoney=" + totalMoney +
                ", remark='" + remark + '\'' +
                '}';
    }
}
