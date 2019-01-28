package com.bdqn.dao.impl;

import com.bdqn.bean.Live;
import com.bdqn.bean.Room;
import com.bdqn.bean.Room;
import com.bdqn.dao.RoomDao;
import com.bdqn.utils.JDBCUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RoomDaoImpl implements RoomDao {

    @Override
    public int addRoom(Connection connection,Object... params) throws Exception {
        String sql = "INSERT INTO t_room_info (id,room_id,room_type,state,location,tele,remark,bed,price,hour_room,hour_price) VALUES(null,?,?,?,?,?,?,?,?,?,round(?, 2))";
        int update = JDBCUtils.update(connection, sql, params);
        return update;
    }

    @Override
    public long getTotal(Connection connection) throws Exception {
        String sql = "SELECT count(0) FROM t_room_info";
        Long total = (Long) JDBCUtils.query(connection, sql, new ScalarHandler<>());
        return total;
    }

    @Override
    public Room getRoomById(Connection connection, String id) throws Exception {
        String sql="SELECT id,room_id roomId,room_type roomType,state,location,tele,remark,bed,price,hour_room hourRoom,hour_price hourPrice FROM " +
                "t_room_info WHERE id = ?";
        Room Room = JDBCUtils.query(connection, sql, new BeanHandler<>(Room.class), id);
        return Room;
    }

    @Override
    public int editRoomSave(Connection connection, Object... params) throws Exception {
        String sql = "UPDATE t_room_info set room_id=?,room_type=?,state=?,location=?,tele=?,remark=?,bed=?,price=?,hour_room=?,hour_price=? " +
                " WHERE id=?";
        int update = JDBCUtils.update(connection, sql, params);
        return update;
    }

    @Override
    public int deleteRoom(Connection connection, String id) throws Exception {
        String sql = "DELETE FROM t_room_info WHERE id = ?";
        int update = JDBCUtils.update(connection, sql, id);
        return update;
    }

    @Override
    public long getSearchTotal(Connection connection, Map<String,String[]> map) throws Exception {
        String sql = "SELECT count(0) FROM t_room_info WHERE 1=1 ";
        sql = structSql(sql, map);
        Object[] params = structParams(map);
        Long total = (Long) JDBCUtils.query(connection, sql, new ScalarHandler<>(),params);
        return total;
    }

    @Override
    public List<Room> roomList(Connection connection, int start, int pageSize) throws Exception {
        String sql="SELECT id,room_id roomId,room_type roomType,state,location,tele,remark,bed,price,hour_room hourRoom,hour_price hourPrice FROM " +
                "t_room_info order by id desc limit ?,?";
        List<Room> query = JDBCUtils.query(connection, sql, new BeanListHandler<Room>(Room.class),start,pageSize);
        return query;
    }

    @Override
    public List<Room> searchRoom(Connection connection, Map<String,String[]> map, int start, int pageSize) throws Exception {
        String sql="SELECT id,room_id roomId,room_type roomType,state,location,tele,remark,bed,price,hour_room hourRoom,hour_price hourPrice FROM " +
                "t_room_info WHERE 1=1 ";
        sql = structSql(sql, map);
        sql += " order by id desc limit ?,?";
        Object[] p = structParams(map);
        Object[] params = null;
        if(p != null){
            params = Arrays.copyOf(p,p.length+2);
        }else {
            params = new Object[2];
        }
        params[params.length-2] = start;
        params[params.length-1] = pageSize;
        System.out.println("params=====>"+Arrays.toString(params));
        List<Room> Rooms = JDBCUtils.query(connection, sql, new BeanListHandler<Room>(Room.class), params);
        return Rooms;
    }

    public Object[] structParams(Map<String,String[]> map){
        String key = "";
        if(!"".equals(map.get("roomId")[0])){
            key += "roomId-";
        }
        if(!"".equals(map.get("roomType")[0])){
            key += "roomType-";
        }
        if(!"".equals(map.get("state")[0])){
            key += "state-";
        }
        if(!"".equals(map.get("location")[0])){
            key += "location-";
        }
        String[] split = null;
        Object[] params = null;
        System.out.println("====>"+key);
        if(!key.equals("")){
            split = key.substring(0, key.lastIndexOf("-")).split("-");
            params = new Object[split.length];
            for (int i = 0; i < split.length; i++) {
                System.out.println(split[i]+"----"+Arrays.toString(map.get(split[i])));
                params[i] = map.get(split[i])[0];
            }
        }
        return params;
    }

    public String structSql(String sql, Map<String,String[]> map){
        if(!"".equals(map.get("roomId")[0])){
            sql += "AND room_id=? ";
        }
        if(!"".equals(map.get("roomType")[0])){
            sql += "AND room_type=? ";
        }
        if(!"".equals(map.get("state")[0])){
            sql += "AND state=? ";
        }
        if(!"".equals(map.get("location")[0])){
            sql += "AND location=? ";
        }
        return sql;
    }
}
