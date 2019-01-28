package com.bdqn.dao;

import com.bdqn.bean.Goods;
import com.bdqn.bean.Live;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface LiveDao {

    /**
     *
     * 添加入住信息
     * @param connection 数据库连接对象
     * @param params 入住信息参数列表
     * @return 执行结果
     * @throws Exception 异常
     */
    int addLive(Connection connection, Object... params) throws Exception;

    /**
     * 计算总条数
     * @param connection 数据库连接对象
     * @return 总条数
     */
    long getTotal(Connection connection) throws Exception;

    /**
     * 根据入住编号查询入住信息
     * @param connection 数据库连接对象
     * @param id 入住编号
     * @return 入住信息
     */
    Live getLiveById(Connection connection, String id) throws Exception;

    /**
     * 根据入住编号修改入住信息
     * @param connection 数据库连接对象
     * @param params 修改的入住信息列表
     * @param params 入住信息列表
     * @return 执行结果
     */
    int editLiveSave(Connection connection, Object... params) throws Exception;

    /**
     * 根据入住编号删除入住信息
     * @param connection 数据库连接对象
     * @param id 入住编号
     * @return 执行结果
     */
    int deleteLive(Connection connection, String id) throws Exception;

    /**
     * 查询指定搜索内容的总条数
     * @param connection 数据库连接对象
     * @param map 搜索内容列表
     * @return 执行结果
     */
    long getSearchTotal(Connection connection, Map<String, String[]> map) throws Exception;

    /**
     * 查询搜索内容的所有入住信息
     * @param connection 数据库连接对象
     * @param map 搜索内容列表
     * @param start 分页开始值
     * @param pageSize 分页每页条数
     * @return 查询结果
     */
    List<Live> searchLive(Connection connection, Map<String, String[]> map, int start, int pageSize) throws Exception;

    /**
     * 获取入住记录及其分页
     * @param connection 数据库连接对象
     * @param start 分页开始值
     * @param pageSize 分页每页条数
     * @return 查询结果
     * @throws Exception
     */
    List<Live> liveList(Connection connection, int start, int pageSize) throws Exception;

    /**
     * 获取所有已入住的客房
     * @param connection 数据库连接对象
     * @return
     */
    List<Live> getLiveRoom(Connection connection) throws Exception;
}
