package com.bdqn.dao.impl;

import com.bdqn.bean.Engage;
import com.bdqn.dao.EngageDao;
import com.bdqn.utils.JDBCUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class EngageDaoImpl implements EngageDao {
    //id,room_id roomId,c_name name,engage_time engageTime,arrive_time arriveTime,engage_mark mark,remark
    @Override
    public int addEngage(Connection connection,Object... params) throws Exception {
        String sql = "INSERT INTO t_engage VALUES(null,?,?,?,?,?,?,?)";
        int update = JDBCUtils.update(connection, sql, params);
        return update;
    }

    @Override
    public List<Engage> engageList(Connection connection, int start, int pageSize) throws Exception {
        String sql="SELECT id,room_id roomId,c_name name,c_tele phone,engage_time engageTime,arrive_time arriveTime,engage_mark mark,remark FROM " +
                "t_engage order by engage_time desc,id desc limit ?,?";
        List<Engage> query = JDBCUtils.query(connection, sql, new BeanListHandler<Engage>(Engage.class),start,pageSize);
        return query;
    }

    @Override
    public long getTotal(Connection connection) throws Exception {
        String sql = "SELECT count(0) FROM t_engage";
        Long total = (Long) JDBCUtils.query(connection, sql, new ScalarHandler<>());
        return total;
    }

    @Override
    public Engage getEngageById(Connection connection, String id) throws Exception {
        String sql="SELECT id,room_id roomId,c_name name,c_tele phone,engage_time engageTime,arrive_time arriveTime,engage_mark mark,remark FROM " +
                "t_engage WHERE id = ?";
        Engage engage = JDBCUtils.query(connection, sql, new BeanHandler<>(Engage.class), id);
        return engage;
    }

    @Override
    public int editEngageSave(Connection connection, Object... params) throws Exception {
        String sql = "UPDATE t_engage set room_id=?,c_name=?,c_tele=?,arrive_time=?,engage_mark=?,remark=? " +
                "WHERE id=?";
        int update = JDBCUtils.update(connection, sql, params);
        return update;
    }

    @Override
    public int deleteEngage(Connection connection, String id) throws Exception {
        String sql = "DELETE FROM t_engage WHERE id = ?";
        int update = JDBCUtils.update(connection, sql, id);
        return update;
    }

    @Override
    public long getSearchTotal(Connection connection, Map<String,String> map) throws Exception {
        String sql = "SELECT count(0) FROM t_engage WHERE 1=1 ";
        sql = structSql(sql, map);
        Object[] params = structParams(map);
        Long total = (Long) JDBCUtils.query(connection, sql, new ScalarHandler<>(),params);
        return total;
    }

    @Override
    public List<Engage> searchEngage(Connection connection, Map<String,String> map, int start, int pageSize) throws Exception {
        String sql="SELECT id,room_id roomId,c_name name,c_tele phone,engage_time engageTime,arrive_time arriveTime,engage_mark mark,remark FROM " +
                "t_engage WHERE 1=1 ";
        sql = structSql(sql, map);
        sql += " order by engage_time desc,id desc limit ?,?";
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
        List<Engage> engages = JDBCUtils.query(connection, sql, new BeanListHandler<Engage>(Engage.class), params);
        return engages;
    }

    public Object[] structParams(Map<String,String> map){
        String key = "";
        if(!"".equals(map.get("name"))){
            key += "name-";
        }
        if(!"".equals(map.get("phone"))){
            key += "phone-";
        }
        if(!"".equals(map.get("engageTime"))){
            key += "engageTime-";
        }
        String[] split = null;
        Object[] params = null;

        if(!key.equals("")){
            split = key.substring(0, key.lastIndexOf("-")).split("-");
            params = new Object[split.length];
            for (int i = 0; i < split.length; i++) {
                params[i] = map.get(split[i]);
            }
        }
        return params;
    }

    public String structSql(String sql,Map<String,String> map){
        if(!"".equals(map.get("name"))){
            sql += "AND c_name=? ";
        }
        if(!"".equals(map.get("phone"))){
            sql += "AND c_tele=? ";
        }
        if(!"".equals(map.get("engageTime"))){
            sql += "AND engage_time=? ";
        }
        return sql;
    }
}
