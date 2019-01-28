package com.bdqn.service;

import com.bdqn.bean.Goods;
import com.bdqn.bean.GoodsConsume;
import com.bdqn.utils.Page;

import java.util.List;
import java.util.Map;

public interface GoodsService {

    /**
     * 添加商品
     * @param params 商品信息列表
     * @return 执行后结果
     */
    int addGoods(Object... params);

    /**
     * 根据商品编号查询信息
     * @param id 商品编号
     * @return 查询结果
     */
    Goods getGoodsById(String id);

    /**
     * 根据商品编号修改商品信息
     * @param params 修改的商品信息列表
     * @return
     */
    int editGoodsSave(Object... params);

    /**
     * 商品列表查询
     * @param pageNum 当前页码
     * @return 返回商品信息
     */
    Page<Goods> goodsList(int pageNum);

    /**
     * 根据商品编号删除商品信息
     * @param id 商品编号
     * @return
     */
    int deleteGoods(String id);

    /**
     * 根据搜索内容搜索商品信息
     * @param pageNum 页码
     * @param map 搜索内容列表
     * @return 搜索结果
     */
    Page<Goods> searchGoods(int pageNum, Map<String, String[]> map);

    /**
     * 查询购买商品时需要的信息(商品列表,已住客房)
     * @return 商品列表,已住客房
     */
    Map<String,Object> buyGoods();
}
