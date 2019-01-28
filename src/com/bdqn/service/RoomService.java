package com.bdqn.service;

import com.bdqn.bean.Room;
import com.bdqn.utils.Page;

import java.util.Map;

public interface RoomService {

    /**
     * 添加客房
     * @param params 客房信息列表
     * @return 执行后结果
     */
    int addRoom(Object...params);

    /**
     * 根据客房编号查询信息
     * @param id 客房编号
     * @return 查询结果
     */
    Room getRoomById(String id);

    /**
     * 根据客房编号修改客房信息
     * @param params 修改的客房信息列表
     * @return
     */
    int editRoomSave(Object...params);

    /**
     * 客房列表查询
     * @param pageNum 当前页码
     * @return 返回客房信息
     */
    Page<Room> roomList(int pageNum);


    /**
     * 根据客房编号删除客房信息
     * @param id 客房编号
     * @return
     */
    int deleteRoom(String id);

    /**
     * 根据搜索内容搜索客房信息
     * @param pageNum 页码
     * @param map 搜索内容列表
     * @return 搜索结果
     */
    Page<Room> searchRoom(int pageNum, Map<String,String[]> map);
}
