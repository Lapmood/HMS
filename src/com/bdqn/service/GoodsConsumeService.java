package com.bdqn.service;

import com.bdqn.bean.Goods;
import com.bdqn.bean.GoodsConsume;
import com.bdqn.utils.Page;

import java.util.Map;

public interface GoodsConsumeService {


    /**
     * 保存购买记录
     * @param goodId 商品编号
     * @param roomId 客户编号
     * @param number 商品数量
     * @param money 总金额
     * @return 执行结果
     */
    int saveBuyGoods(String goodId, String roomId, String number, String money);

    /**
     * 获取所有购买记录
     * @param pageNum 页码
     * @return
     */
    Page<GoodsConsume> consumeList(Integer pageNum);

    /**
     * 根据搜索内容搜索商品信息
     * @param pageNum 页码
     * @param map 搜索内容列表
     * @return 搜索结果
     */
    Page<GoodsConsume> searchGoodsConsume(int pageNum, Map<String, String[]> map);
}
