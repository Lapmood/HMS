package com.bdqn.service.impl;

import com.bdqn.bean.Room;
import com.bdqn.bean.Room;
import com.bdqn.dao.RoomDao;
import com.bdqn.dao.impl.RoomDaoImpl;
import com.bdqn.service.RoomService;
import com.bdqn.utils.JDBCUtils;
import com.bdqn.utils.Page;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class RoomServiceImpl implements RoomService{

    private RoomDao roomDao;

    public RoomServiceImpl(){
        roomDao = new RoomDaoImpl();
    }

    @Override
    public int addRoom(Object... params) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行添加操作
            int i = roomDao.addRoom(connection,params);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //获取指定的预订信息
    @Override
    public Room getRoomById(String id) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行查询操作
            Room Room = roomDao.getRoomById(connection, id);
            return Room;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //修改预订信息
    @Override
    public int editRoomSave(Object...params) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {

            //执行查询操作
            int i = roomDao.editRoomSave(connection, params);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteRoom(String id) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行查询操作
            int i = roomDao.deleteRoom(connection, id);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //预定列表
    @Override
    public Page<Room> roomList(int pageNum) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //清除总条数
            long total = roomDao.getTotal(connection);
            Page<Room> page = new Page<>(pageNum,total);

            //执行查询操作
            List<Room> engages = roomDao.roomList(connection,page.getStart(),page.getPageSize());
            page.startPage(engages);
            return page;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<Room> searchRoom(int pageNum, Map<String,String[]> map) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //清除总条数
            long total = roomDao.getSearchTotal(connection,map);
            Page<Room> page = new Page<>(pageNum,total);
            //执行查询操作
            List<Room> engages = roomDao.searchRoom(connection,map,page.getStart(),page.getPageSize());
            page.startPage(engages);
            return page;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
