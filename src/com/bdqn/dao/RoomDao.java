package com.bdqn.dao;

import com.bdqn.bean.Live;
import com.bdqn.bean.Room;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface RoomDao {

    /**
     *
     * 添加客房信息
     * @param connection 数据库连接对象
     * @param params 客房信息参数列表
     * @return 执行结果
     * @throws Exception 异常
     */
    int addRoom(Connection connection, Object... params) throws Exception;

    /**
     * 计算总条数
     * @param connection 数据库连接对象
     * @return 总条数
     */
    long getTotal(Connection connection) throws Exception;

    /**
     * 根据客房编号查询客房信息
     * @param connection 数据库连接对象
     * @param id 客房编号
     * @return 客房信息
     */
    Room getRoomById(Connection connection, String id) throws Exception;

    /**
     * 根据客房编号修改客房信息
     * @param connection 数据库连接对象
     * @param params 修改的客房信息列表
     * @param params 客房信息列表
     * @return 执行结果
     */
    int editRoomSave(Connection connection, Object... params) throws Exception;

    /**
     * 根据客房编号删除客房信息
     * @param connection 数据库连接对象
     * @param id 客房编号
     * @return 执行结果
     */
    int deleteRoom(Connection connection, String id) throws Exception;

    /**
     * 查询指定搜索内容的总条数
     * @param connection 数据库连接对象
     * @param map 搜索内容列表
     * @return 执行结果
     */
    long getSearchTotal(Connection connection, Map<String, String[]> map) throws Exception;

    /**
     * 查询搜索内容的所有客房信息
     * @param connection 数据库连接对象
     * @param map 搜索内容列表
     * @param start 分页开始值
     * @param pageSize 分页每页条数
     * @return 查询结果
     */
    List<Room> searchRoom(Connection connection, Map<String, String[]> map, int start, int pageSize) throws Exception;

    /**
     * 获取客房记录及其分页
     * @param connection 数据库连接对象
     * @param start 分页开始值
     * @param pageSize 分页每页条数
     * @return 查询结果
     * @throws Exception
     */
    List<Room> roomList(Connection connection, int start, int pageSize) throws Exception;

}
