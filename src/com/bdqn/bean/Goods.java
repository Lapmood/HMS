package com.bdqn.bean;

import java.math.BigDecimal;

public class Goods {

    private Integer id;//主键编号
    private String name;//商品名
    private BigDecimal price;//商品价格
    private Integer number;//商品数据
    private String purpose;//商品用途

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
