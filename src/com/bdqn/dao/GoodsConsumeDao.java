package com.bdqn.dao;

import com.bdqn.bean.Goods;
import com.bdqn.bean.GoodsConsume;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface GoodsConsumeDao {
    /**
     * 保存购买记录
     * @param connection 数据库连接对象
     * @param params 购买记录信息列表
     * @return 执行结果
     */
    int saveBuyGoods(Connection connection, Object...params) throws Exception;

    /**
     * 获取购买记录及其分页
     * @param connection 数据库连接对象
     * @param start 分页开始值
     * @param pageSize 分页每页条数
     * @return
     */
    List<GoodsConsume> consumeList(Connection connection, int start, int pageSize) throws Exception;

    /**
     * 获取购买记录总数
     * @param connection 数据库连接对象
     * @return
     */
    long getConsumeTotal(Connection connection) throws Exception;

    /**
     * 查询指定搜索内容的总条数
     * @param connection 数据库连接对象
     * @param map 搜索内容列表
     * @return 执行结果
     */
    long getSearchTotal(Connection connection, Map<String, String[]> map) throws Exception;

    /**
     * 封装 GoodsConsume 对象数据
     * @param query 多表联查结果
     * @return 购买记录集合
     * @throws Exception
     */
    List<GoodsConsume> encapsulationData(List<Map<String, Object>> query) throws Exception;

    /**
     * 查询搜索内容的所有商品信息
     * @param connection 数据库连接对象
     * @param map 搜索内容列表
     * @param start 分页开始值
     * @param pageSize 分页每页条数
     * @return 查询结果
     */
    List<GoodsConsume> searchGoodsConsume(Connection connection, Map<String, String[]> map, int start, int pageSize) throws Exception;


    /**
     * 封装条件查询的参数列表
     * @param map 所有条件参数列表列表
     * @return 返回需要的条件参数
     */
    Object[] structParams(Map<String,String[]> map);

    /**
     * 封装条件查询的SQL语句
     * @param sql SQL语句
     * @param map 所有条件参数列表列表
     * @return 封装后的SQL语句
     */
    String structSql(String sql,Map<String,String[]> map);
}
