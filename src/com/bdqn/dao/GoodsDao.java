package com.bdqn.dao;

import com.bdqn.bean.Goods;
import com.bdqn.bean.GoodsConsume;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface GoodsDao {

    /**
     *
     * 添加商品信息
     * @param connection 数据库连接对象
     * @param params 商品信息参数列表
     * @return 执行结果
     * @throws Exception 异常
     */
    int addGoods(Connection connection, Object... params) throws Exception;

    /**
     * 计算总条数
     * @param connection 数据库连接对象
     * @return 总条数
     */
    long getTotal(Connection connection) throws Exception;

    /**
     * 根据商品编号查询商品信息
     * @param connection 数据库连接对象
     * @param id 商品编号
     * @return 商品信息
     */
    Goods getGoodsById(Connection connection, String id) throws Exception;

    /**
     * 根据商品编号修改商品信息
     * @param connection 数据库连接对象
     * @param params 修改的商品信息列表
     * @param params 商品信息列表
     * @return 执行结果
     */
    int editGoodsSave(Connection connection, Object... params) throws Exception;

    /**
     * 根据商品编号删除商品信息
     * @param connection 数据库连接对象
     * @param id 商品编号
     * @return 执行结果
     */
    int deleteGoods(Connection connection, String id) throws Exception;

    /**
     * 查询指定搜索内容的总条数
     * @param connection 数据库连接对象
     * @param map 搜索内容列表
     * @return 执行结果
     */
    long getSearchTotal(Connection connection, Map<String, String[]> map) throws Exception;

    /**
     * 查询搜索内容的所有商品信息
     * @param connection 数据库连接对象
     * @param map 搜索内容列表
     * @param start 分页开始值
     * @param pageSize 分页每页条数
     * @return 查询结果
     */
    List<Goods> searchGoods(Connection connection, Map<String, String[]> map, int start, int pageSize) throws Exception;

    List<Goods> goodsList(Connection connection, int start, int pageSize) throws Exception;

    /**
     * 获取所有商品
     * @param connection 数据库连接对象
     * @return
     */
    List<Goods> getGoods(Connection connection) throws Exception;

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
