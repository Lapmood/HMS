package com.bdqn.dao.impl;

import com.bdqn.bean.Live;
import com.bdqn.bean.Room;
import com.bdqn.dao.LiveDao;
import com.bdqn.utils.JDBCUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LiveDaoImpl implements LiveDao {

    @Override
    public int addLive(Connection connection,Object... params) throws Exception {
        String sql = "INSERT INTO t_livein (id,room_id,in_no,customer_name,sex,zj_type,zj_no,number,in_time,days,foregift,remark) VALUES(null,?,?,?,?,?,?,?,?,?,?,?)";
        int update = JDBCUtils.update(connection, sql, params);
        return update;
    }

    @Override
    public long getTotal(Connection connection) throws Exception {
        String sql = "SELECT count(0) FROM t_livein";
        Long total = (Long) JDBCUtils.query(connection, sql, new ScalarHandler<>());
        return total;
    }

    @Override
    public Live getLiveById(Connection connection, String id) throws Exception {
        String sql="SELECT id,room_id roomId,in_no inNo,customer_name customerName,sex,zj_type zjType,zj_no zjNo,number,in_time inTime,days,foregift foreGift,reality_days realityDays,chk_time chkTime,money,remark FROM " +
                "t_livein WHERE id = ?";
        Live Live = JDBCUtils.query(connection, sql, new BeanHandler<>(Live.class), id);
        return Live;
    }

    @Override
    public int editLiveSave(Connection connection, Object... params) throws Exception {
        String sql = "UPDATE t_livein set room_id=?,in_no=?,customer_name=?,sex=?,zj_type=?,zj_no=?,number=?,days=?,foregift=?,remark=?" +
                " WHERE id=?";
        int update = JDBCUtils.update(connection, sql, params);
        return update;
    }

    @Override
    public int deleteLive(Connection connection, String id) throws Exception {
        String sql = "DELETE FROM t_livein WHERE id = ?";
        int update = JDBCUtils.update(connection, sql, id);
        return update;
    }

    @Override
    public long getSearchTotal(Connection connection, Map<String,String[]> map) throws Exception {
        String sql = "SELECT count(0) FROM t_livein WHERE 1=1 ";
        sql = structSql(sql, map);
        Object[] params = structParams(map);
        Long total = (Long) JDBCUtils.query(connection, sql, new ScalarHandler<>(),params);
        return total;
    }

    @Override
    public List<Live> liveList(Connection connection, int start, int pageSize) throws Exception {
        String sql="SELECT id,room_id roomId,in_no inNo,customer_name customerName,sex,zj_type zjType,zj_no zjNo,number,in_time inTime,days,foregift foreGift,reality_days realityDays,chk_time chkTime,money,remark FROM " +
                "t_livein order by id desc limit ?,?";
        List<Live> query = JDBCUtils.query(connection, sql, new BeanListHandler<Live>(Live.class),start,pageSize);
        return query;
    }

    @Override
    public List<Live> searchLive(Connection connection, Map<String,String[]> map, int start, int pageSize) throws Exception {
        String sql="SELECT id,room_id roomId,in_no inNo,customer_name customerName,sex,zj_type zjType,zj_no zjNo,number,in_time inTime,days,foregift foreGift,reality_days realityDays,chk_time chkTime,money,remark FROM " +
                "t_livein WHERE 1=1 ";
        //拼接SQL语句
        sql = structSql(sql, map);
        sql += " order by id desc limit ?,?";
        //获取需要的参数
        Object[] p = structParams(map);
        Object[] params = null;
        if(p != null){
            params = Arrays.copyOf(p,p.length+2);
        }else {
            params = new Object[2];
        }
        params[params.length-2] = start;
        params[params.length-1] = pageSize;
        List<Live> Lives = JDBCUtils.query(connection, sql, new BeanListHandler<Live>(Live.class), params);
        return Lives;
    }

    //获取需要的参数
    public Object[] structParams(Map<String,String[]> map){
        String key = "";
        if(!"".equals(map.get("inNo")[0])){
            key += "inNo-";
        }
        if(!"".equals(map.get("customerName")[0])){
            key += "customerName-";
        }
        if(!"".equals(map.get("inTime")[0])){
            key += "inTime-";
        }
        if(!"".equals(map.get("chkTime")[0])){
            key += "chkTime-";
        }
        String[] split = null;
        Object[] params = null;
        if(!key.equals("")){
            split = key.substring(0, key.lastIndexOf("-")).split("-");
            params = new Object[split.length];
            for (int i = 0; i < split.length; i++) {
                System.out.println(split[i]+"----"+Arrays.toString(map.get(split[i])));
                params[i] = map.get(split[i])[0];
            }
        }

        System.out.println("=====>"+params);
        return params;
    }

    //拼接SQL语句
    public String structSql(String sql,Map<String,String[]> map){
        if(!"".equals(map.get("inNo")[0])){
            sql += "AND in_no=? ";
        }
        if(!"".equals(map.get("customerName")[0])){
            sql += "AND customer_name=? ";
        }
        if(!"".equals(map.get("inTime")[0])){
            sql += "AND date(in_time)=? ";
        }
        if(!"".equals(map.get("chkTime")[0])){
            sql += "AND date(chk_time)=? ";
        }

        return sql;
    }

    @Override
    public List<Live> getLiveRoom(Connection connection) throws Exception {
        String sql="SELECT id,room_id roomId FROM " +
                "t_livein WHERE chk_time is null";
        List<Live> query = JDBCUtils.query(connection, sql, new BeanListHandler<Live>(Live.class));
        return query;
    }
}
