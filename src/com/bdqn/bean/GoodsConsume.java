package com.bdqn.bean;

import java.math.BigDecimal;

public class GoodsConsume {

    private Integer id;//主键,编号
    private Goods goods;//商品对象
    private Live live;//入住对象
    private Integer number;//数量
    private BigDecimal money;//总价格

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Live getLive() {
        return live;
    }

    public void setLive(Live live) {
        this.live = live;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "GoodsConsume{" +
                "id=" + id +
                ", goods=" + goods +
                ", live=" + live +
                ", number=" + number +
                ", money=" + money +
                '}';
    }
}
